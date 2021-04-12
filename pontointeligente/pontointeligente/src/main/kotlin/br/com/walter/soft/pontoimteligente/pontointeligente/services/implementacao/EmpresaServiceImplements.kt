package br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImplements : EmpresaService {
    override fun buscarPorCnpj(cnpj: String): Empresa? {
        TODO("Not yet implemented")
    }

    override fun percistir(empresa: Empresa): Empresa {
        TODO("Not yet implemented")
    }
}