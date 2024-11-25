package com.example.app.dao

import com.example.app.model.Task

class TasksDao {
    fun add(task: Task){
        Companion.tasks.add(task)
    }

    fun searchAll() : List<Task>{
        return Companion.tasks.toList()
    }

    companion object {
        private val tasks = mutableListOf<Task>(
            Task(
                "Kotlin",
                "fazer lição kotlin",
                2
            )
        )
    }
}