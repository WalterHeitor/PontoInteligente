package br.com.walter.soft.pontoimteligente.pontointeligente.request

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


data class NovoFuncionarioRequest(
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    val nome: String,
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 5, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    @field:Email(message = "Email invalido")
    val email: String,

    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    val cpf: String,

    val perfil: String? = null,
    var empresaId: NovaEmpresaRequest? = null,

    val senha: String? = null,

    val valorDaHora: Double? = 0.0,
    val qtdHorasDeTrabalhoPorDia: Float? = 0.0f,
    val qtdHorasDeAmoço: Float? = 0.0f,
) {
    fun toModel(): Funcionario = Funcionario(
        nome = nome,
        email = email,
        cpf = cpf,
        perfilEnum = PerfilEnum.valueOf(perfil.toString()),
        senha = senha,
        empresa = empresaId !!.toModel ()
    )
    fun setEmpresaDto(empresa: Empresa): NovaEmpresaRequest = NovaEmpresaRequest(rasaoSocial = empresa.razaoSocial, cnpj = empresa.cnpj)
    companion object{
        fun converterDto(listFuncionario: List<Funcionario>): List<NovoFuncionarioRequest>{
            return listFuncionario.map { it ->
                NovoFuncionarioRequest(
                    nome = it.nome,
                    email = it.email,
                    cpf = it.cpf,
                    perfil = it.perfilEnum.name,
                    empresaId = it.empresa.let {it ->
                        NovaEmpresaRequest(it!!.razaoSocial, cnpj = it.cnpj)
                    },
                    senha = it.senha,
                    valorDaHora = it.valorDaHora,
                    qtdHorasDeTrabalhoPorDia = it.qtdHorasDeTrabalhoPorDia,
                    qtdHorasDeAmoço = it.qtdHorasDeAmoço

                )
            }
        }
    }
}