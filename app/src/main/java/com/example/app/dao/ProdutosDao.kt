package com.example.app.dao

import com.example.app.model.Produto

class ProdutosDao {
    fun add(produto: Produto){
        Companion.produtos.add(produto)
    }

    fun searchAll() : List<Produto>{
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                nome = "Salada de frutas",
                descricao = "Laranja, maçã e uva",
                valor = java.math.BigDecimal("19.90")
            )
        )
    }
}