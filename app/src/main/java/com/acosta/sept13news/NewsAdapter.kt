package com.acosta.sept13news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val onClick: (News) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsList: List<News> = emptyList()
    private var selectedPosition: Int = RecyclerView.NO_POSITION

    fun submitList(list: List<News>) {
        newsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news, position)
    }

    override fun getItemCount(): Int = newsList.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val headlineTextView: TextView = itemView.findViewById(R.id.headline)

        fun bind(news: News, position: Int) {
            headlineTextView.text = news.headLine
            itemView.isSelected = position == selectedPosition
            itemView.setOnClickListener {
                val previousPosition = selectedPosition
                selectedPosition = adapterPosition
                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)
                onClick(news)
            }
        }
    }
}
