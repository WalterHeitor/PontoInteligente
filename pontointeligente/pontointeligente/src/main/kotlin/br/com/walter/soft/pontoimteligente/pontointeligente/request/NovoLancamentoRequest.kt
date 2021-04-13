package br.com.walter.soft.pontoimteligente.pontointeligente.request

import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class NovoLancamentoRequest(
    val descricao: String? = "",
    val localizacao: String? = "",
    @field:NotBlank(message = "Nao pode ser vazio")
    val data: LocalDate? = null,
    @field:NotBlank(message = "Nao pode ser vazio")
    val tipo: String? = null,
    val funcionarioId: String? = null
)
