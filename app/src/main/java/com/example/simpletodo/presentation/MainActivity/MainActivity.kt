package com.example.simpletodo.presentation.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.simpletodo.R
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.dropdown_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.item2 -> todoAdapter.deleteAllTodos()
        }
        return super.onOptionsItemSelected(item)
    }

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