package com.alessiodipasquale.todoexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val todoAdapter = TodoAdapter(mutableListOf<Todo>())

    lateinit var btnAdd : Button
    lateinit var btnDone : Button
    lateinit var etTodo : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = todoAdapter

        etTodo = findViewById(R.id.etTodo);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener { v ->
            val textToAdd = etTodo.text.toString()
            if(textToAdd.isNotEmpty()) {
                todoAdapter.addTodo(Todo(textToAdd, false))
                etTodo.text.clear()
            }
        }

        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener { v ->
            todoAdapter.deleteDone()
        }
    }
}