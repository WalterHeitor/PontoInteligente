package br.com.walter.soft.pontoimteligente.pontointeligente.repositories

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EmpresaRepository : JpaRepository<Empresa, UUID>{

    fun findByCnpj(cnpj: String) : Optional<Empresa>

    //fun findByCnpj(cnpj: String) : Empresa
}