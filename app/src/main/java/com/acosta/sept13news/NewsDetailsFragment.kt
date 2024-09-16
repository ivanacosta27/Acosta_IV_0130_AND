package com.acosta.sept13news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView

class NewsDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headline = arguments?.getString("headline")
        val details = arguments?.getString("details")

        view.findViewById<TextView>(R.id.headline_details).text = headline
        view.findViewById<TextView>(R.id.news_content).text = details
    }
}
