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
    override fun buscaPorFuncionarioId(id: UUID, pageable: Pageable): Page<Lancamento> {
        TODO("Not yet implemented")
    }

    override fun buscaPorId(id: Long): Optional<Lancamento> {
        TODO("Not yet implemented")
    }

    override fun percistir(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)

    override fun remover(id: Long) {
        TODO("Not yet implemented")
    }
}