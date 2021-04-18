package br.com.walter.soft.pontoimteligente.pontointeligente.validations

import br.com.walter.soft.pontoimteligente.pontointeligente.request.NovoFuncionarioRequest
import org.springframework.stereotype.Component
import org.springframework.util.Assert
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
@Component
class EmailUnique : Validator {

    @PersistenceContext
    lateinit var entityManager: EntityManager

    override fun supports(clazz: Class<*>): Boolean =
        clazz.isAssignableFrom(NovoFuncionarioRequest::class.java)


    override fun validate(target: Any, errors: Errors) {
        if (target is NovoFuncionarioRequest){
            val query = entityManager.createQuery("SELECT 1 FROM Funcionario f WHERE f.email = :email")
            query.setParameter("email", target.email)
            val resultList = query.resultList
            Assert.state(resultList.size >= 1, "Email ${target.email} já cadastrado")
            if (resultList.size >= 1 ){
            errors.rejectValue("email", "", "Email ${target.email} já cadastrado")
            }
        }
    }
}