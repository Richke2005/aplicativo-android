package com.example.app.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.load
import coil3.request.placeholder
import com.example.app.R
import com.example.app.dao.TasksDao
import com.example.app.databinding.ActivityFormularioTaskBinding
import com.example.app.databinding.FormularioImagemBinding
import com.example.app.extensions.tentaCarregarImagem
import com.example.app.model.Task
import com.example.app.ui.dialog.FormularioImagemDialog


class FormularioTaskActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityFormularioTaskBinding.inflate(layoutInflater)
    }
    private var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        title = "Cadastrar Tarefa"

        configuraBotaoSalvar()
        binding.activityFormularioTaskImagem.setOnClickListener{
            FormularioImagemDialog(this).mostra(url){ imagem ->
                url = imagem
                binding.activityFormularioTaskImagem.tentaCarregarImagem(url)
            }
        }

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioTaskBotaoSalvar
        val dao = TasksDao()
        botaoSalvar.setOnClickListener {
            val newTask: Task = createTask()
            dao.add(newTask)
            finish()
        }
    }

    private fun createTask(): Task {
        val campoNome = binding.activityFormularioTaskNome
        val campoDesc = binding.activityFormularioTaskDescricao
        val campoValor = binding.activityFormularioTaskPrazo

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
            prazo = prazo,
            imagem = url
        )
    }
}