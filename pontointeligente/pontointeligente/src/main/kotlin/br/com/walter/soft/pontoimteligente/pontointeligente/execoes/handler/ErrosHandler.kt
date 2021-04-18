package br.com.walter.soft.pontoimteligente.pontointeligente.execoes.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//@ControllerAdvice
class ErrosHandler( val massageSource: MessageSource) {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun ErrosHandler.methodArgumentNotValidException(e: MethodArgumentNotValidException,
                                                    ) :
            ResponseEntity<List<ErrorsResponse>>{
        var erros: List<FieldError> = e.bindingResult.fieldErrors
        var response: MutableList<ErrorsResponse> = arrayListOf()
        erros.forEach { erro ->
            var message: String = massageSource.getMessage(erro, LocaleContextHolder.getLocale())
            response.add(ErrorsResponse(erro.field, message))
        }
        return ResponseEntity.badRequest().body(response)
    }
}

class ErrorsResponse (
    val campo: String,
    val menssagem: String
        ){

}
