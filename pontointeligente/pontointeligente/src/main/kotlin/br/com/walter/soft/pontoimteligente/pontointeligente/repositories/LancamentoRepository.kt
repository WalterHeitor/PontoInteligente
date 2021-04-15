package br.com.walter.soft.pontoimteligente.pontointeligente.repositories

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface LancamentoRepository : JpaRepository<Lancamento, Long> {

    /**
     * busca paginada pageable do spring
     * retornado Page do tipo Lancamento
     */
    fun findByFuncionarioId(funcionarioId: UUID, pageable: Pageable): Page<Lancamento>
}