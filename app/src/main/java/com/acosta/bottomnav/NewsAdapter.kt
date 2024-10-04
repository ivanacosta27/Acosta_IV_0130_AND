package com.acosta.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headlineTextView: TextView = itemView.findViewById(R.id.headline)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.headlineTextView.text = newsItem.headLine

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("headline", newsItem.headLine)
                putString("details", newsItem.details)
            }
            holder.itemView.findNavController().navigate(R.id.newsDetailsFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
