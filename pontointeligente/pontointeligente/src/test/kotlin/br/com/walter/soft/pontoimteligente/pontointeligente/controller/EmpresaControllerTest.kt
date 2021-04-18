package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovaEmpresaRequest
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoLancamentoRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.platform.commons.logging.LoggerFactory
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
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
internal class EmpresaControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

   // @MockBean
    @Autowired
    lateinit var empresaRepository: EmpresaRepository

    val LOGGER = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `deve cria uma nova empresa`(){
        mockMvc.post("/api/empresas"){
            contentType = MediaType.APPLICATION_JSON
            content = NovaEmpresaRequest(rasaoSocial = "WalterSoft", cnpj = "48.248.806/0001-20").toJson()
        }.andExpect {
            status { isCreated() }
        }
//        Mockito.verify(empresaRepository).save(ArgumentMatchers.any())

        with(empresaRepository.findByCnpj("48.248.806/0001-20")){
            Assertions.assertAll({

                Assertions.assertEquals("48.248.806/0001-20", get().cnpj)
            })
        }
    }
    fun NovaEmpresaRequest.toJson(): String = objectMapper.writeValueAsString(this)
}