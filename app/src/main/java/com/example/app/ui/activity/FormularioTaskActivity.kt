package com.example.app.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.R
import com.example.app.dao.TasksDao
import com.example.app.model.Task


class FormularioTaskActivity : AppCompatActivity(R.layout.activity_formulario_task) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configuraBotaoSalvar()

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_task_botao_salvar)
        val dao = TasksDao()
        botaoSalvar.setOnClickListener {
            val newTask: Task = createTask()
            dao.add(newTask)
            finish()
        }
    }

    private fun createTask(): Task {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_task_nome)
        val campoDesc = findViewById<EditText>(R.id.activity_formulario_task_descricao)
        val campoValor = findViewById<EditText>(R.id.activity_formulario_task_prazo)
        val nome: String = campoNome.text.toString()
        val desc: String = campoDesc.text.toString()
        val prazoEmTexto: String = campoValor.text.toString()

        val prazo: Int = if(prazoEmTexto.isBlank()) {
             0
        }else{
            prazoEmTexto.toInt()
        }

        return Task(
            nome = nome,
            descricao = desc,
            prazo = prazo
        )
    }
}