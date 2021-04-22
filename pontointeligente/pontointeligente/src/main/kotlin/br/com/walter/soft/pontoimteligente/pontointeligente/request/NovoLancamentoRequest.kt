package br.com.walter.soft.pontoimteligente.pontointeligente.request



import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.TipoEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Lancamento
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
) {
    fun toModel(): Lancamento = Lancamento(
        tipoEnum = TipoEnum.valueOf(tipo.toString()),
        descricao = this.descricao,
        localizacao = this.localizacao,
        data = LocalDate.now(),
    )
}


