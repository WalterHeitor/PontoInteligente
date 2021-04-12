package br.com.walter.soft.pontoimteligente.pontointeligente.utils


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


internal class SenhaUtilsTest{
    private val SENHA = "123456"
    private  val bCryptPasswordEncoder = BCryptPasswordEncoder()
    @Test
    fun `deve gerar a senha`(){
        val hash = SenhaUtils.gerarBcrypt(SENHA)
        Assertions.assertTrue(bCryptPasswordEncoder.matches(SENHA, hash))
    }
}