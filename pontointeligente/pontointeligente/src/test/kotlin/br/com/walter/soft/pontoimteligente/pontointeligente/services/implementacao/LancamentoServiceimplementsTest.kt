package br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.TipoEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Lancamento
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.LancamentoRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.services.LancamentoService
import br.com.walter.soft.pontoimteligente.pontointeligente.utils.SenhaUtils
import javassist.runtime.Desc
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.DEFAULT_DIRECTION
import org.springframework.data.domain.Sort.by
import java.time.LocalDate


import java.util.*
import kotlin.collections.ArrayList
import kotlin.jvm.Throws
@SpringBootTest
internal class LancamentoServiceimplementsTest {

    @Autowired
    private val lancamentoService: LancamentoService? = null
    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    private val id: UUID = UUID.randomUUID()


    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        //        ?.findByFuncionarioId(id, PageRequest(1, 10, by(Sort.Direction.ASC))))
//        BDDMockito
//            .given<Page<Lancamento>>(lancamentoRepository
//            ?.findByFuncionarioId(id, PageRequest.of(1,10)))
//            .willReturn(PageImpl(ArrayList<Lancamento>()))
//
//        BDDMockito.given(lancamentoRepository?.findById(1L))
//            .willReturn(Optional.of(lancamento()))

        BDDMockito.given(lancamentoRepository?.save(Mockito.any(Lancamento::class.java)))
            .willReturn(lancamento())
    }


//    @Test
//    fun buscaPorFuncionarioId() {
//    }

//    @Test
//    fun buscaPorId() {
//    }

    @Test
    fun percistir() {
        val lancamento: Lancamento? = lancamentoService?.percistir(lancamento())
        Assertions.assertNotNull(lancamento)
    }

//    @Test
//    fun remover() {
//    }

    private fun lancamento(): Lancamento =
        Lancamento(TipoEnum.INICIO_TRABALHO, data = LocalDate.now(), funcionario = funcionario())

    private fun funcionario(): Funcionario = Funcionario(
        nome = "Walter",
        email = "email@email.com",
        cpf = "532.193.840-72",
        perfilEnum = PerfilEnum.ROLE_ADMIN,
        senha = SenhaUtils.gerarBcrypt("123456"),
        empresa = empresa()
    )
    private fun empresa(): Empresa = Empresa("WalterSoft", "50.684.152/0001-29")
}