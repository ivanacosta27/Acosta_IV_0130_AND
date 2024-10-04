package com.acosta.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val newsList = listOf(
            News("Breaking News: Market Crash", "Stocks plummet as market faces unexpected crash."),
            News("Weather Alert: Severe Thunderstorms", "Severe thunderstorms expected across the region with possible hail and flooding."),
            News("Tech Giants Announce New Innovations", "Top tech companies unveil groundbreaking technologies at the annual conference."),
            News("Sports Update: Championship Game Results", "The championship game ends with a dramatic final play, securing victory for the underdogs."),
            News("Political Debate Highlights", "Highlights from last night's political debate reveal major policy differences."),
            News("Health Advisory: Flu Season Approaches", "Health officials urge vaccinations as flu season approaches with increased severity."),
            News("Entertainment: New Blockbuster Released", "The highly anticipated blockbuster film hits theaters this weekend."),
            News("Travel Warning: Airline Strike", "Major airline strike causes travel disruptions and cancellations worldwide."),
            News("Science Breakthrough: New Discovery", "Scientists announce a major breakthrough in renewable energy research."),
            News("Education Reform: New Policies Implemented", "New education policies aim to improve student outcomes and teacher support."),
            News("Local Hero Saves the Day", "A local resident's heroic actions help avert a major disaster in the community."),
            News("Economic Forecast: Growth Predictions", "Economic experts provide optimistic growth predictions for the coming year."),
            News("Art Exhibition: Famous Painter's Work", "An art exhibition showcasing the work of a renowned painter opens to the public."),
            News("Business Update: Company Merger", "Two major companies announce a merger that will reshape the industry."),
            News("Crime Report: Major Arrest Made", "Law enforcement makes a significant arrest in a high-profile criminal case."),
            News("Technology Review: Latest Gadgets", "A review of the latest gadgets and tech products hitting the market."),
            News("Environmental Concern: New Pollution Levels", "Recent data shows alarming increases in pollution levels affecting urban areas."),
            News("Celebrity News: High-Profile Wedding", "A high-profile celebrity wedding captures the attention of fans and media alike."),
            News("Space Exploration: New Mission Launched", "A new space mission is launched with hopes of discovering more about the universe."),
            News("Financial Markets: Economic Impact Analysis", "Analysts provide insights into how recent events are affecting financial markets."),
            News("Community Event: Annual Fair", "The annual community fair offers fun and entertainment for all ages.")
        )

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NewsAdapter(newsList)
        recyclerView.adapter = adapter

        return view
    }
}
