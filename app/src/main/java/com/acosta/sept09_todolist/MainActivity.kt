package com.acosta.sept09_todolist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var adapter: ToDoAdapter
    private val tasks = mutableListOf<ToDo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view)
        editText = findViewById(R.id.edittext)
        addButton = findViewById(R.id.add_button)

        adapter = ToDoAdapter(this, tasks)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val taskText = editText.text.toString()
            if (taskText.isNotEmpty()) {
                tasks.add(ToDo(taskText, false))
                adapter.notifyDataSetChanged()
                editText.text.clear()
            } else {
                Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show()
            }
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            showEditDeleteDialog(position)
            true
        }
    }

    private fun showEditDeleteDialog(position: Int) {
        val options = arrayOf("Edit", "Delete")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose an option")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> showEditTaskDialog(position)
                1 -> deleteTask(position)
            }
        }
        builder.show()
    }

    private fun showEditTaskDialog(position: Int) {
        val taskToEdit = tasks[position]

        val input = EditText(this)
        input.setText(taskToEdit.text)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Edit Task")
        builder.setView(input)

        builder.setPositiveButton("Save") { _, _ ->
            val newTask = input.text.toString()
            if (newTask.isNotEmpty()) {
                tasks[position].text = newTask
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    private fun deleteTask(position: Int) {
        tasks.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}
