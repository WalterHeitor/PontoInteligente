package br.com.walter.soft.pontoimteligente.pontointeligente.repositories

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FuncionarioRepository : JpaRepository<Funcionario, UUID> {

    fun findByEmail(email: String): Optional<Funcionario>

    fun findByCpf(cpf: String): Optional<Funcionario>

    //fun findOne(id: UUID): Optional<Funcionario>


}