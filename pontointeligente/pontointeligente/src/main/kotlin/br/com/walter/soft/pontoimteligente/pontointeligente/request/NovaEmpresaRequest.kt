package br.com.walter.soft.pontoimteligente.pontointeligente.request

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import org.hibernate.validator.constraints.br.CNPJ
import javax.validation.constraints.NotBlank

data class NovaEmpresaRequest(
    @field:NotBlank(message = "O campo nao deve ser vazio ou nulo.")
    val rasaoSocial: String,
    @field:CNPJ(message = "Deve ser um documento válido")
    val cnpj: String,
) {
    fun toModel(): Empresa = Empresa(razaoSocial = rasaoSocial, cnpj = cnpj)
}