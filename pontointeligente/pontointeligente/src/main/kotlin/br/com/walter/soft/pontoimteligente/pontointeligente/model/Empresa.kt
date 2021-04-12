package br.com.walter.soft.pontoimteligente.pontointeligente.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Empresa(
    val razaoSocial: String,
    val cnpj: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //val id: Long? = null
    val id: UUID? = null
    override fun toString(): String {
        return "Empresa(razaoSocial='$razaoSocial', cnpj='$cnpj', id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Empresa

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}