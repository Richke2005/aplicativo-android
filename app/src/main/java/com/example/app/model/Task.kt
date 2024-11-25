package com.example.app.model

data class Task (
    val nome: String,
    val descricao: String,
    val prazo: Int,
    val imagem: String? = null
)