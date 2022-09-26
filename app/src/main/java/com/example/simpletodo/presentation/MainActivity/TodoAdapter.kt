package com.example.simpletodo.presentation.MainActivity



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpletodo.R
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(
    private val todos: MutableList<TodoList>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    private fun toggleStrikeThrough(tvTodo: TextView, completed: Boolean) {
        if(completed) {
            tvTodo.paintFlags = tvTodo.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodo.paintFlags = tvTodo.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    fun addTodo(todo: TodoList) {
        todos.add(todo)
        notifyItemInserted(todos.size -1)
    }

    fun deleteDoneTodos() {
        todos.removeAll { newTodo ->
            newTodo.completed
        }
        notifyDataSetChanged()
    }

    fun deleteAllTodos() {
        alert()
        todos.clear()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todos[position]
        holder.itemView.apply {
            tvTodo.text = currentTodo.todo
            checkBox.isChecked = currentTodo.completed
            toggleStrikeThrough(tvTodo, currentTodo.completed)
            checkBox.setOnCheckedChangeListener { _, completed ->
                toggleStrikeThrough(tvTodo, completed)
                currentTodo.completed = !currentTodo.completed
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}