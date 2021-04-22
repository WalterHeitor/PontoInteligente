package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.FuncionarioRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovaEmpresaRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
internal class FuncionariosControllerTest{
    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var objectMapper: ObjectMapper
//    @MockBean
    @Autowired
    lateinit var empresaRepository: EmpresaRepository
    @MockBean
    lateinit var funcionarioRepositoty: FuncionarioRepository
    lateinit var empresa: Empresa
    @BeforeEach
    internal fun setUp(){
      //  BDDMockito.given(empresaRepository.save(empresa())).willReturn(empresa())
        empresa = empresaRepository.save(empresa())
    }

    @AfterEach
    internal fun tearDown(){
        empresaRepository.delete(empresa)
    }
    private fun empresa(): Empresa = Empresa(razaoSocial = "SoftHeitor", cnpj = "94.149.752/0001-62")

    @Test
    fun `deve cadastrar funcionario`(){
        mockMvc.post("/api/funcionarios"){
            contentType = MediaType.APPLICATION_JSON
            content = FuncionarioRequest(
                nome = "Walter",
                email = "email@email.com",
                cpf = "770.718.290-12",
                perfil = PerfilEnum.ROLE_USUARIO.toString(),
                empresaCNPJ = "94.149.752/0001-62",
                senha = "123456"
            ).toJson()
        }.andExpect {
            status { isCreated() }
        }
    }
    fun FuncionarioRequest.toJson(): String = objectMapper.writeValueAsString(this)
}