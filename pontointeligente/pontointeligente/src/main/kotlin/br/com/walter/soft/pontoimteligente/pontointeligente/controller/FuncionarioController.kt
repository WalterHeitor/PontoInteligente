package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.FuncionarioRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovaEmpresaRequest
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoFuncionarioRequest
import br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao.FuncionarioServiceImplements
import br.com.walter.soft.pontoimteligente.pontointeligente.validations.EmailUnique
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/api/funcionarioss")
class FuncionarioController (
    val funcionarioService: FuncionarioServiceImplements,
    val emailUnique: EmailUnique,
    val empresaRepository: EmpresaRepository,
        ) {

    @InitBinder
    fun initBinder(binder: WebDataBinder){
        binder.addValidators(emailUnique)
    }

    val LOGGER = LoggerFactory.getLogger(this::class.java)
    @Transactional
    @PostMapping("/{empresaCNPJ}")
    fun criar(@PathVariable("empresaCNPJ") empresaCNPJ: String,
              @RequestBody novoFuncionarioRequest: NovoFuncionarioRequest,
                builder: UriComponentsBuilder): ResponseEntity<Any> {
        LOGGER.info("-----entrando no metodo------------")
        val possivelEmpresa = empresaRepository.findByCnpj(empresaCNPJ)
        LOGGER.info("-------possivel Empresa----------- $possivelEmpresa")
        if (!possivelEmpresa.isPresent) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body( "Empresa nao encontrada")
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa nao encontrada")
        }

        novoFuncionarioRequest.setEmpresaDto(possivelEmpresa.get())

        with(novoFuncionarioRequest.toModel()){
            funcionarioService.percistir(this)
            val location = builder.path("/api/funcionarios/{id}")
                .buildAndExpand(this.id).toUri()
            return ResponseEntity.created(location).body(novoFuncionarioRequest)
        }
    }
    @GetMapping
    fun listar(): ResponseEntity<List<NovoFuncionarioRequest>> {
        val listaFuncionarios = funcionarioService.funcionarioRepository.findAll()
        val listDTO = NovoFuncionarioRequest.converterDto(listaFuncionarios)
        return ResponseEntity.ok(listDTO)


    }
}


