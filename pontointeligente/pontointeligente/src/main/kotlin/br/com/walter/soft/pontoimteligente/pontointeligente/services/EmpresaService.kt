package br.com.walter.soft.pontoimteligente.pontointeligente.services

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun percistir(empresa: Empresa): Empresa
}