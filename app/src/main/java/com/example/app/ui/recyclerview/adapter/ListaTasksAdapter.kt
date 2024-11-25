package com.example.app.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder
import com.example.app.R
import com.example.app.databinding.TaskItemBinding
import com.example.app.extensions.tentaCarregarImagem
import com.example.app.model.Task

class ListaTasksAdapter(
    private val context: Context,
    tasks: List<Task>
) : RecyclerView.Adapter<ListaTasksAdapter.ViewHolder>() {

    private val dataSet = tasks.toMutableList()

    class ViewHolder(private val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(task: Task) {
            val nome = binding.taskItemNome
            nome.text = task.nome
            val descricao = binding.taskItemDescricao
            descricao.text = task.descricao
            val prazo = binding.taskItemPrazo
            prazo.text = "${task.prazo} Dias"

            val visibilidade = if(task.imagem != null){
                View.VISIBLE
            }else{
                View.GONE
            }

            binding.taskItemImageView.visibility = visibilidade
            binding.taskItemImageView.tentaCarregarImagem(task.imagem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TaskItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = dataSet[position]
        holder.vincula(task)
    }

    fun update(tasks: List<Task>) {
        this.dataSet.clear()
        this.dataSet.addAll(tasks)
        notifyDataSetChanged()
    }

}
