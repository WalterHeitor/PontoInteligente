package br.com.walter.soft.pontoimteligente.pontointeligente.execoes

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler

class ExceptionHandler {
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun excptionHandler(e: MethodArgumentNotValidException): ResponseEntity<String> {
        val globalErrors = e.globalErrors
        return ResponseEntity.badRequest().build()
    }
}