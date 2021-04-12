package br.com.walter.soft.pontoimteligente.pontointeligente.services

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import java.util.*

interface FuncionariaoService {

    fun buscarPorId(id: UUID): Optional<Funcionario>
    fun buscarPorEmail(email: String): Optional<Funcionario>
    fun buscarPorCpf(cpf: String): Optional<Funcionario>

    fun percistir(funcionario: Funcionario): Funcionario
}