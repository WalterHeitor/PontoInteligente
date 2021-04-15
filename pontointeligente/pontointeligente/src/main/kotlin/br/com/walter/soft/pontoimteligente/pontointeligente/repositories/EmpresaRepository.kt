package br.com.walter.soft.pontoimteligente.pontointeligente.repositories

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface EmpresaRepository : JpaRepository<Empresa, UUID>{

    fun findByCnpj(cnpj: String) : Optional<Empresa>

    //SELECT BIN_TO_UUID(uuid) FROM foo
   // SELECT uuid_of(id) id FROM users

    //fun findByCnpj(cnpj: String) : Empresa
}