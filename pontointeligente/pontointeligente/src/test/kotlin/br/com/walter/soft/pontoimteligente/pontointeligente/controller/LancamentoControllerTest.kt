package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.LancamentoRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovaEmpresaRequest
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoFuncionarioRequest
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoLancamentoRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import javax.persistence.EntityManager


@WebMvcTest
/**
 * Uma maneira mais indiomatica de injetar dependencias
 * @TestConstructor(autowireMode =  TestConstructor.AutowireMode.ALL) // anotacao para injetar no construtor
internal class LancamentoControllerTest(
val mockMvc: MockMvc,
){
 */

internal class LancamentoControllerTest {
    /**
     * duas maneiras para injetar mockMvc do Spring.
     *
     *     @Autowired
    var mockMvc : MockMvc? = null

    @Autowired
    lateinit var mockMvc : MockMvc
     */

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

//    @MockBean
//    lateinit var lancamentoRepository: LancamentoRepository

    @Test
    fun `deve criar novo lancamento`() {

        mockMvc.post("/api/lancamentos") {
            contentType = MediaType.APPLICATION_JSON
            content = NovoLancamentoRequest(
                descricao = "confecção de projeto de cartao de ponto",
                localizacao = "Itumbiara",
                data = null,
                tipo = "INICIO_TRABALHO",
                funcionarioId = NovoFuncionarioRequest(
                    nome = "Walter",
                    email = "email@email.com",
                    cpf = "",
                    perfil = "ROLE_ADMIN",
                    empresaId = NovaEmpresaRequest(rasaoSocial = "WalterSoft", cnpj = "")
                )
            ).toJson()
        }.andExpect {
            status { isOk() }
        }
        /**
         *
         */
        //Mockito.verify(lancamentoRepository).save(ArgumentMatchers.any())
    }

    fun NovoLancamentoRequest.toJson(): String = objectMapper.writeValueAsString(this)
}