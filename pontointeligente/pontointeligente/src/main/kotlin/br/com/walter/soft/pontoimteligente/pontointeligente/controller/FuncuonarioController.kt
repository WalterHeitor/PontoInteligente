package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.validations.EmailUnique
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class FuncuonarioController (
    val emailUnique: EmailUnique
        ) {

    @InitBinder
    fun initBinder(binder: WebDataBinder){
        binder.addValidators(emailUnique)
    }
}