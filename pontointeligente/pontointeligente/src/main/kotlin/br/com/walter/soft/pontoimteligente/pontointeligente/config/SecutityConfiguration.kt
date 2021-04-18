package br.com.walter.soft.pontoimteligente.pontointeligente.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
@EnableWebSecurity
@Configuration
class SecutityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests().antMatchers(HttpMethod.POST, "/api/empresas").permitAll()
            .anyRequest().permitAll()
            .and()
            .csrf().disable()
    }
}