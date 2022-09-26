package com.example.simpletodo.presentation.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpletodo.R
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rv_view.adapter = todoAdapter
        rv_view.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val todoTitle = editText.text.toString()
            if(todoTitle.isNotEmpty()) {
                val newTodo = TodoList(todoTitle)
                todoAdapter.addTodo(newTodo)
                editText.text.clear()
            }
        }
        doneButton.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}