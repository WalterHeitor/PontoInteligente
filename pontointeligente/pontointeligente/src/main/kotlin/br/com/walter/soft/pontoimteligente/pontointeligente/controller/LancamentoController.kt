package br.com.walter.soft.pontoimteligente.pontointeligente.controller


import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.LancamentoRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoLancamentoRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/lancamentos")
class LancamentoController(
    //val lancamentoRepository: LancamentoRepository
){
    @Value("\${paginacao.por_pagina}")
    val qtdPorPagina = 15

    @PostMapping
    fun adicionar(@RequestBody novoLancamentoRequest: NovoLancamentoRequest,

                    ){
//        val possivelFuncionario = funcionarioRepository.findById(UUID.fromString(novoLancamentoRequest.funcionarioId))
//        if (possivelFuncionario.isPresent){
//            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario nao encontrado")
//        }

       // lancamentoRepository.save(novoLancamentoRequest.toModel())

    }

}