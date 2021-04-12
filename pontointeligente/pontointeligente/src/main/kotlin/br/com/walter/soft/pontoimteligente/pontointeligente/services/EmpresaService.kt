package br.com.walter.soft.pontoimteligente.pontointeligente.services

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import java.util.*

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Optional<Empresa>

    fun percistir(empresa: Empresa): Empresa?
}