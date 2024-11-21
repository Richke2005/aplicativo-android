package com.example.orgs.ui.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produto
import java.math.BigDecimal
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val reciclerView = findViewById<RecyclerView>(R.id.reciclerView)
        reciclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(
                nome = "teste",
                descricao = "test desc",
                valor = BigDecimal("19.99")
            ),
            Produto(
                nome = "teste 1",
                descricao = "test desc 1",
                valor = BigDecimal("20.99")
            ),
            Produto(
                nome = "teste 2",
                descricao = "test desc 2",
                valor = BigDecimal("30.99")
            )
        ))
        reciclerView.layoutManager = LinearLayoutManager(this)
    }
}