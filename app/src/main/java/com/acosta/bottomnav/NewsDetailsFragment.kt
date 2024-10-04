package com.acosta.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NewsDetailsFragment : Fragment() {

    private lateinit var headlineTextView: TextView
    private lateinit var newsContentTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_details, container, false)

        headlineTextView = view.findViewById(R.id.headline_details)
        newsContentTextView = view.findViewById(R.id.news_content)

        val headline = arguments?.getString("headline")
        val details = arguments?.getString("details")

        headlineTextView.text = headline
        newsContentTextView.text = details

        return view
    }
}
