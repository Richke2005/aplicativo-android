package com.example.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.orgs.model.Produto
import com.example.orgs.R
import java.math.BigDecimal


class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val campoDesc = findViewById<EditText>(R.id.descricao)
            val campoValor = findViewById<EditText>(R.id.valor)
            val nome: String = campoNome.text.toString()
            val desc: String = campoDesc.text.toString()
            val valorEmTexto: String = campoValor.text.toString()

            val valor = if(valorEmTexto.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(valorEmTexto)
            }

            val produtoNovo: Produto = Produto(
                nome = nome,
                descricao = desc,
                valor = valor
            )

            Log.i("FormularioProduto", "oncreate $produtoNovo")
        }
    }
}