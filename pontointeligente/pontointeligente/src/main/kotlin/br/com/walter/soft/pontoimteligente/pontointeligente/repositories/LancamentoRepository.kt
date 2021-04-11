package br.com.walter.soft.pontoimteligente.pontointeligente.repositories

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Lancamento
import org.springframework.data.jpa.repository.JpaRepository

interface LancamentoRepository : JpaRepository<Lancamento, Long> {
}