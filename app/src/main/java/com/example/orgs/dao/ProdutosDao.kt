package com.example.orgs.dao

import com.example.orgs.model.Produto

class ProdutosDao {
    fun add(produto: Produto){
        Companion.produtos.add(produto)
    }

    fun searchAll() : List<Produto>{
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}