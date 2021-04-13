package br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao

import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import org.junit.jupiter.api.Assertions


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*
import kotlin.jvm.Throws

@SpringBootTest
internal class EmpresaServiceImplementsTest{

    @Autowired
    val empresaService: EmpresaServiceImplements? = null

    @MockBean
    private val empresaRepository: EmpresaRepository? = null

    private val Cnpj = "50.684.152/0001-29"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(empresaRepository?.findByCnpj(Cnpj)).willReturn(Optional.of(empresa()))
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun `deve buscar empresa por cnpj`(){
        val empresa: Empresa = empresaService!!.buscarPorCnpj(Cnpj).get()
        Assertions.assertNotNull(empresa)
    }
    @Test
    fun `deve persistir a empresa`(){
        val empresa: Empresa? = empresaService?.percistir(empresa())
        Assertions.assertNotNull(empresa)
    }

    private fun empresa(): Empresa = Empresa("WalterSoft", Cnpj)
    }




