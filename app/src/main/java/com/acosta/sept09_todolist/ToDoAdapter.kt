package com.acosta.sept09_todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class ToDoAdapter(
    private val context: Context,
    private val todoList: MutableList<ToDo>
) : BaseAdapter() {

    override fun getCount(): Int {
        return todoList.size
    }

    override fun getItem(position: Int): ToDo {
        return todoList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        val currentToDo = getItem(position)

        viewHolder.textView.text = currentToDo.text
        viewHolder.checkBox.isChecked = currentToDo.isChecked

        viewHolder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            currentToDo.isChecked = isChecked
        }

        return view
    }

    private class ViewHolder(view: View) {
        val textView: TextView = view.findViewById(R.id.text_view)
        val checkBox: CheckBox = view.findViewById(R.id.checkbox)
        val imageView: ImageView = view.findViewById(R.id.imageview)
    }
}
