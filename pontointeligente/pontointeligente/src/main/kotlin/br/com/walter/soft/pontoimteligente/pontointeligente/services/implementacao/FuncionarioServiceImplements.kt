package br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.FuncionarioRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.services.FuncionariaoService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FuncionarioServiceImplements(
    val funcionarioRepository: FuncionarioRepository
) : FuncionariaoService {
    override fun buscarPorId(id: UUID): Optional<Funcionario> = funcionarioRepository.findOne(id)

    override fun buscarPorEmail(email: String): Optional<Funcionario> = funcionarioRepository.findByEmail(email)

    override fun buscarPorCpf(cpf: String): Optional<Funcionario> = funcionarioRepository.findByCpf(cpf)

    override fun percistir(funcionario: Funcionario): Funcionario = funcionarioRepository.save(funcionario)
}