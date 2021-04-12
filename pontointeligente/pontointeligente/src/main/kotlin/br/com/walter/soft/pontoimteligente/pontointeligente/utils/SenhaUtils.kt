package br.com.walter.soft.pontoimteligente.pontointeligente.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    companion object{
        fun gerarBcrypt(senha: String): String = BCryptPasswordEncoder().encode(senha)
    }
}