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
    val id: UUID? = null
}