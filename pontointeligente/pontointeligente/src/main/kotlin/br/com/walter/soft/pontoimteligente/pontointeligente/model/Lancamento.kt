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
    val data: LocalDate? = null,

    @field:ManyToOne(cascade = [CascadeType.ALL])
    val funcionario: Funcionario

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lancamento

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}