package com.example.app.ui.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.example.app.dao.TasksDao
import com.example.app.databinding.ActivityListaTasksBinding
import com.example.app.ui.recyclerview.adapter.ListaTasksAdapter


class ListaTasksActivity : AppCompatActivity() {
    private val dao = TasksDao()
    private val adapter = ListaTasksAdapter(context = this, tasks = dao.searchAll())
    private val binding by lazy {
        ActivityListaTasksBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraReciclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAll())
    }

    private fun configuraFab() {
        val fab = binding.activityListaTasksFab
        fab.setOnClickListener {
            vaiParaFormTask()
        }
    }

    private fun vaiParaFormTask() {
        val intent = Intent(this, FormularioTaskActivity::class.java)
        startActivity(intent)
    }

    private fun configuraReciclerView(): Unit {
        val reciclerView = binding.activityListaTasksReciclerView
        reciclerView.adapter = adapter
    }
}