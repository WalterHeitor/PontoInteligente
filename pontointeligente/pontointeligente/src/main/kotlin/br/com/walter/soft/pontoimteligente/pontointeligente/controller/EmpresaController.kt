package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmpresaController(
    val empresaRepository: EmpresaRepository
) {

    @PostMapping("/empresas")
    fun criar(@RequestBody empresa: Empresa) : String{
        empresaRepository.save(empresa)
        return empresa.toString()
    }
}