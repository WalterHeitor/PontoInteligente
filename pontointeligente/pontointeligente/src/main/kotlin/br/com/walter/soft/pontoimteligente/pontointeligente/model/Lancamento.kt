package br.com.walter.soft.pontoimteligente.pontointeligente.model

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.TipoEnum
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
class Lancamento(
    val tipoEnum: TipoEnum,
    val descricao: String? = "",
    val localizacao: String? = "",

    @field:ManyToOne(cascade = [CascadeType.ALL])
    val funcionario: Funcionario

) {
    val data: LocalDate = LocalDate.now()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}