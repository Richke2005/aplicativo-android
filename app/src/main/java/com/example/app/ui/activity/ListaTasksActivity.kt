package com.example.app.ui.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.dao.TasksDao
import com.example.app.ui.recyclerview.adapter.ListaTasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListaTasksActivity : AppCompatActivity(R.layout.activity_lista_tasks) {
    private val dao = TasksDao()
    private val adapter = ListaTasksAdapter(context = this, tasks = dao.searchAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraReciclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAll())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_tasks_fab)
        fab.setOnClickListener {
            vaiParaFormProduto()
        }
    }

    private fun vaiParaFormProduto() {
        val intent = Intent(this, FormularioTaskActivity::class.java)
        startActivity(intent)
    }

    private fun configuraReciclerView(): Unit {
        val reciclerView = findViewById<RecyclerView>(R.id.activity_lista_tasks_reciclerView)
        reciclerView.adapter = adapter
    }
}