package com.acosta.sept13news

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var newsFragment: NewsFragment
    private lateinit var newsDetailsFragment: NewsDetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsFragment = NewsFragment()
        newsDetailsFragment = NewsDetailsFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newsFragment)
                .commit()
        }
    }

    fun showNewsDetails(news: News) {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Landscape mode: show in details_container
            supportFragmentManager.beginTransaction()
                .replace(R.id.details_container, NewsDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putString("headline", news.headLine)
                        putString("details", news.details)
                    }
                })
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NewsDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putString("headline", news.headLine)
                        putString("details", news.details)
                    }
                })
                .addToBackStack(null)
                .commit()
        }
    }
}
