package br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmpresaServiceImplements( val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Optional<Empresa> = empresaRepository.findByCnpj(cnpj)

    //nao ha nessecidade
    override fun percistir(empresa: Empresa): Empresa? = empresaRepository.save(empresa)
}