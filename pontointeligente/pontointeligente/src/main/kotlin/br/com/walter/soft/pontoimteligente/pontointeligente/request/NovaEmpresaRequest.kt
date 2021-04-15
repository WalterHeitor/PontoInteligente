package br.com.walter.soft.pontoimteligente.pontointeligente.request

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa

data class NovaEmpresaRequest(
    val rasaoSocial: String,
    val cnpj: String,
) {
    fun toModel(): Empresa = Empresa(razaoSocial = rasaoSocial, cnpj = cnpj)
}