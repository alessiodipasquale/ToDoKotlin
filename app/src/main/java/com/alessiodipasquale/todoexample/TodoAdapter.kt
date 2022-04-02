package com.alessiodipasquale.todoexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TodoAdapter(
    private val todos : MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder> () {
    class TodoViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvTodo: TextView = v.findViewById(R.id.tvTodo);
        val cbTodo: CheckBox = v.findViewById(R.id.cbTodo);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        //holder.tvTodo.text = todo.title;
        //holder.cbTodo.isChecked = todo.isChecked;
        holder.apply {
            tvTodo.text = todo.title
            cbTodo.isChecked = todo.isChecked
            cbTodo.setOnCheckedChangeListener { _, b -> todo.isChecked = b }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun addTodo(newTodo: Todo) {
        todos.add(newTodo)
        notifyItemInserted(todos.size-1)
    }

    fun deleteDone(){
        todos.removeAll{el -> el.isChecked}
        notifyDataSetChanged();
    }
}