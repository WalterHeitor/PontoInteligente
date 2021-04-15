package br.com.walter.soft.pontoimteligente.pontointeligente.services.implementacao

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.FuncionarioRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*
import kotlin.jvm.Throws

@SpringBootTest
internal class FuncionarioServiceImplementsTest{
    @Autowired
    private val funcionarioService: FuncionarioServiceImplements? = null
    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    private val id: UUID = UUID.randomUUID()
    private val email: String = "email@email.com"
    private val cpf: String = "532.193.840-72"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
            .willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf = cpf )).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByEmail(email = email )).willReturn(Optional.of(funcionario()))
    }

    @Test
    fun `deve percistir o funcionario`(){
        val funcionario: Funcionario? = this.funcionarioService?.percistir(funcionario())
        Assertions.assertNotNull(funcionario)
    }
    @Test
    fun `deve buscar por CPF o funcionario`(){
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorCpf(cpf)?.get()
        Assertions.assertNotNull(funcionario)
    }
    @Test
    fun `deve buscar por Email o funcionario`(){
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorEmail(email)?.get()
        Assertions.assertNotNull(funcionario)
    }
    @Test
    fun `deve buscar por ID o funcionario`(){
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorId(id)?.get()
        Assertions.assertNotNull(funcionario)
    }


    private fun funcionario(): Funcionario = Funcionario(
        nome = "Walter",
        email = email,
        cpf = cpf,
        perfilEnum = PerfilEnum.ROLE_ADMIN,
        senha = "123456", // SenhaUtils.gerarBcrypt("123456"),
        empresa = empresa()
    )
    private fun empresa(): Empresa = Empresa("WalterSoft", "50.684.152/0001-29")
}