package br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Lancamento
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.LancamentoRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
@Service
class LancamentoServiceimplements(
    val lancamentoRepository: LancamentoRepository
) : LancamentoService {
    override fun buscaPorFuncionarioId(id: UUID, pageable: Pageable): Page<Lancamento>
                = lancamentoRepository.findByFuncionarioId(id, pageable)

    override fun buscaPorId(id: Long): Optional<Lancamento> = lancamentoRepository.findById(id)

    override fun percistir(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)

    override fun remover(id: Long) = lancamentoRepository.deleteById(id)

    fun deletarLancamento(lancamento: Lancamento) = lancamentoRepository.delete(lancamento)
}