package br.com.walter.soft.pontoimteligente.pontointeligente.model

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Funcionario(
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    @field:Column(nullable = false)
    val nome: String,

    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    @field:Column(nullable = false)
    val email: String,

    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    @field:Column(nullable = false)
    val cpf: String,

    val senha: String?,
    val valorDaHora: Double? = 0.0,
    val qtdHorasDeTrabalhoPorDia: Float? = 0.0f,
    val qtdHorasDeAmoço: Float? = 0.0f,

    @field:Enumerated(EnumType.STRING)
    val perfilEnum: PerfilEnum,

    @field:ManyToOne (cascade = [CascadeType.MERGE,])
    var empresa: Empresa? = null

) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")

    //val id: Long? = null
    var id: UUID? = null


    override fun toString(): String {
        return "Funcionario(nome='$nome', email='$email', cpf='$cpf', senha=$senha, valorDaHora=$valorDaHora, qtdHorasDeTrabalhoPorDia=$qtdHorasDeTrabalhoPorDia, qtdHorasDeAmoço=$qtdHorasDeAmoço, perfilEnum=$perfilEnum, empresa=$empresa, id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Funcionario

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}