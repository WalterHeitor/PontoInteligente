package br.com.walter.soft.pontoimteligente.pontointeligente

import br.com.walter.soft.pontoimteligente.pontointeligente.enuns.PerfilEnum
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Empresa
import br.com.walter.soft.pontoimteligente.pontointeligente.model.Funcionario
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.EmpresaRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.repositories.FuncionarioRepository
import br.com.walter.soft.pontoimteligente.pontointeligente.utils.SenhaUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import javax.transaction.Transactional

@SpringBootApplication
class PontointeligenteApplication(
    val empresaRepository: EmpresaRepository,
    val funcionarioRepository: FuncionarioRepository,
    ) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val LOGGER = LoggerFactory.getLogger(this::class.java)

//        Instaciacao(LOGGER)
 //       buscaDeEmpresaEFuncionario(LOGGER)
    }

    fun buscaDeEmpresaEFuncionario(LOGGER: Logger) {
//        val f1 = funcionarioRepository.findByCpf("721.926.140-39")
//        LOGGER.info("buscado por cpf $f1")
//        val e = empresaRepository.findByCnpj("04.397.978/0001-90")
//        val e1 = empresaRepository.findById(UUID.fromString(e.get().id.toString()))
//        LOGGER.info("----------empresa----------> $e")
//        LOGGER.info("----------empresa----------> $e1")
    }
}

fun main(args: Array<String>) {
    runApplication<PontointeligenteApplication>(*args)
}

private fun PontointeligenteApplication.Instaciacao(LOGGER: Logger) {
//    	LimparBanco(empresaRepository = empresaRepository, funcionarioRepository = funcionarioRepository)
    //instaciação
        instanciar(LOGGER)
}

private fun PontointeligenteApplication.instanciar(LOGGER: Logger) {
    val empresa: Empresa = Empresa(
        razaoSocial = "WalterSoft",
        cnpj = "04.397.978/0001-90"
    )
    val id = empresaRepository.save(empresa)
    LOGGER.info("Empresa $empresa")

    val admin: Funcionario = Funcionario(
        nome = "Walter Heitor",
        email = "walter@email.com",
        cpf = "721.926.140-39",
        senha = SenhaUtils.gerarBcrypt("123456"),
        empresa = id,
        perfilEnum = PerfilEnum.ROLE_ADMIN
    )
    LOGGER.info("ADIMIN $admin")
    funcionarioRepository.save(admin)
    val funcionario: Funcionario = Funcionario(
        nome = "Rioderleia Lima",
        email = "rioderleia@email.com",
        cpf = "983.438.680-05",
        senha = SenhaUtils.gerarBcrypt("654321"),
        empresa = id,
        perfilEnum = PerfilEnum.ROLE_USUARIO
    )
    LOGGER.info("funcionario $funcionario")
    funcionarioRepository.save(funcionario)

    println("Empresa id ${empresa.id}")
    println("Admin id ${admin.id}")
    println("Funcionario ${funcionario.id}")
}

fun LimparBanco(empresaRepository: EmpresaRepository, funcionarioRepository: FuncionarioRepository) {
    //cenario
    funcionarioRepository.deleteAll()
    empresaRepository.deleteAll()

}