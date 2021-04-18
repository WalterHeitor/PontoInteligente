package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.LancamentoRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovaEmpresaRequest
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoFuncionarioRequest
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoLancamentoRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post


//@WebMvcTest
/**
 * Uma maneira mais indiomatica de injetar dependencias
 * @TestConstructor(autowireMode =  TestConstructor.AutowireMode.ALL) // anotacao para injetar no construtor
internal class LancamentoControllerTest(
val mockMvc: MockMvc,
){
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
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

    //@MockBean
    @Autowired
    lateinit var lancamentoRepository: LancamentoRepository

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
         * Teste se esta salvando lancamento.
         */
 //       Mockito.verify(lancamentoRepository).save(ArgumentMatchers.any())
        /**
         *
         */
//        with(lancamentoRepository.findAll()){
//            Assertions.assertAll({
//                Assertions.assertTrue(size == 1)
//                Assertions.assertEquals("Itumbiara1", get(0).localizacao)
//            })
//        }
    }

    fun NovoLancamentoRequest.toJson(): String = objectMapper.writeValueAsString(this)
}