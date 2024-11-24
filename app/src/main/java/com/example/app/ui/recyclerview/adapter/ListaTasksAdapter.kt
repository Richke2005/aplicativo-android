package com.example.app.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.model.Task

class ListaTasksAdapter(
    private val context: Context,
    tasks: List<Task>
) : RecyclerView.Adapter<ListaTasksAdapter.ViewHolder>() {

    private val dataSet = tasks.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(task: Task) {
            val nome = itemView.findViewById<TextView>(R.id.task_item_nome)
            nome.text = task.nome
            val descricao = itemView.findViewById<TextView>(R.id.task_item_descricao)
            descricao.text = task.descricao
            val valor = itemView.findViewById<TextView>(R.id.task_item_prazo)
            valor.text = "${task.prazo} dias"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
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
