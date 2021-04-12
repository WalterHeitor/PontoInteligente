package br.com.walter.soft.pontoimteligente.pontointeligente.services

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface LancamentoService {

    fun buscaPorFuncionarioId(id: UUID, pageable: Pageable): Page<Lancamento>

    fun buscaPorId(id: Long): Optional<Lancamento>

    fun percistir(lancamento: Lancamento): Lancamento

    fun remover(id: Long)
}