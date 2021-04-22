package br.com.walter.soft.pontoimteligente.pontointeligente.controller

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.TipoEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.FuncionarioRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovaEmpresaRequest
import org.hibernate.validator.constraints.Length
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/api/funcionarios")
class FuncionariosController (val empresaRepository: EmpresaRepository,
                              val funcionarioRepository: FuncionarioRepository,){

    val LOGGER = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun criar(@RequestBody @Valid request: FuncionarioRequest,
                                builder: UriComponentsBuilder): ResponseEntity<Any>{
        val possivelEmpresa = empresaRepository.findByCnpj(request.empresaCNPJ.toString())
        if (!possivelEmpresa.isPresent)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa com CNPJ = ${request.empresaCNPJ.toString()}" +
                    " nao encontrada")
        val funcionario = request.toModel()
        funcionario.empresa = possivelEmpresa.get()
        funcionarioRepository.save(funcionario)
        val location = builder.path("/api/funcionarios/{id}").buildAndExpand(funcionario.id).toUri()
        return ResponseEntity.created(location).body(request)
    }
    @GetMapping
    fun listar(): ResponseEntity<List<FuncionarioRequest>> {
        val listaDeFuncionarios = funcionarioRepository.findAll()
        val listaDeDtos = FuncionarioRequest.converterParaDto(listaDeFuncionarios)
        return ResponseEntity.ok().body(listaDeDtos)
    }
    @GetMapping("/{id}")
    fun listarPorId(@PathVariable("id") id: UUID): ResponseEntity<Any> {
        val possivelFuncionario = funcionarioRepository.findById(id)
        if (!possivelFuncionario.isPresent) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario nao encontrado na base de dados.")
        }
        LOGGER.info("funcionario encontrado ${possivelFuncionario.get()}")
        return ResponseEntity.ok().body(possivelFuncionario)
    }
    @Transactional
    @DeleteMapping("/{id}")
    fun deletarPorId(@PathVariable("id") id: UUID): ResponseEntity<Any> {
        val possivelFuncionario = funcionarioRepository.findById(id)
        if (!possivelFuncionario.isPresent) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario nao encontrado na base de dados.")
        }
        funcionarioRepository.delete(possivelFuncionario.get())
        LOGGER.info("funcionario encontrado ${possivelFuncionario.get()}")
        return ResponseEntity.ok().body("${possivelFuncionario.get().nome} deletado com sucesso!!!")
    }

}

data class FuncionarioRequest(
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    val nome: String,
    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 5, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    @field:Email(message = "Email invalido")
    val email: String,

    @field:NotBlank(message = "Nao pode ser nulo ou em branco")
    @field:Length(min= 3, max= 200, message = "deve conter minimo de {min} e maximo de {max}")
    val cpf: String,

    val perfil: String? = null,
    var empresaCNPJ: String? = null,

    val senha: String? = null,

    val valorDaHora: Double? = 0.0,
    val qtdHorasDeTrabalhoPorDia: Float? = 0.0f,
    val qtdHorasDeAmoço: Float? = 0.0f,
){
    fun toModel():Funcionario = Funcionario(
        nome = this.nome,
        email = this.email,
        cpf = this.cpf,
        perfilEnum = PerfilEnum.valueOf(perfil.toString()),
        senha = this.senha,
    )

    /**
     * funçao para converter uma lista de funcionarios do banco para uma lista de funcionarios DTOs
     */
    companion object{
    fun converterParaDto(lista: List<Funcionario>): List<FuncionarioRequest> {
        return lista.map<Funcionario, FuncionarioRequest> {
            FuncionarioRequest(
                nome = it.nome,
                email = it.email,
                cpf = it.cpf,
                perfil = PerfilEnum.valueOf(it.perfilEnum.name).toString(),
                empresaCNPJ = it.empresa?.cnpj,
                senha = it.senha,
                valorDaHora = it.valorDaHora,
                qtdHorasDeTrabalhoPorDia = it.qtdHorasDeTrabalhoPorDia,
                qtdHorasDeAmoço = it.qtdHorasDeAmoço
            )
        }
    }

    }

}