package br.com.walter.soft.pontoimteligente.pontointeligente.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CadastroPFDto(
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    val nome: String,
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 5, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    @field:Email(message = "Email invalido")
    val email: String,
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    val senha:String,
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    val cpf: String,
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    val cnpj: String,

    val perfil: String? = null,
    val empresaId: String? = null,

    val valorDaHora: Double? = null,
    val qtdHorasDeTrabalhoPorDia: Float? = null,
    val qtdHorasDeAmoço: Float? = null,
)
