package br.com.walter.soft.pontoimteligente.pontointeligente.request

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
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
    val empresaId: NovaEmpresaRequest? = null,

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
}