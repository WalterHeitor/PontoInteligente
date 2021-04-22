package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovaEmpresaRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api/empresas")
class EmpresaController(val empresaRepository: EmpresaRepository,
                                       ) { //@field:Autowired val builder: UriComponentsBuilder

//    @Autowired
//    val builder: UriComponentsBuilder? = null

    @PostMapping
 //   @Transactional
    fun criar(@RequestBody @Valid novaEmpresaRequest: NovaEmpresaRequest,
              builder: UriComponentsBuilder) : ResponseEntity<NovaEmpresaRequest>{


        /**
         * also recebe uma funcao que recebe uma empresa,
         * que devolve Unit que devolve o proprio objeto.
         *
         * let recebe uma funcao e retorna o retorno da funcao
         */

        /*
        novaEmpresaRequest.toModel().also { empresa -> empresaRepository.save(empresa) }
                                    .let { ResponseEntity.ok().build<Unit>() }
        with(novaEmpresaRequest.toModel()) {
            empresaRepository.save(this)
            return ResponseEntity.ok().build()
        }

        val empresa = empresaRepository.save(novaEmpresaRequest.toModel())
        val uri = builder!!.path("/api/empresas/{id}").buildAndExpand(empresa.id).toUri()
        return ResponseEntity.created(uri).body(novaEmpresaRequest)

        with(novaEmpresaRequest.toModel()) {
            empresaRepository.save(this)
            val uri = builder!!.path("/api/empresas").buildAndExpand(this.id).toUri()
            return ResponseEntity.created(uri).body(novaEmpresaRequest)
        }
         */
        with(novaEmpresaRequest.toModel()) {
            empresaRepository.save(this)
            val uri = builder.path("/api/empresas/{id}").buildAndExpand(this.id.toString()).toUri()
            return ResponseEntity.created(uri).body(novaEmpresaRequest)
        }

    }
}