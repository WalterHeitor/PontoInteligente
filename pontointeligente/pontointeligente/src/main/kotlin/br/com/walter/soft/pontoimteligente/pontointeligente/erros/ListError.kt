package br.com.walter.soft.pontoimteligente.pontointeligente.erros

data class ListError<T> (
    val erros: ArrayList<String> = arrayListOf(), // inicializar.
    var data: T? = null
        )