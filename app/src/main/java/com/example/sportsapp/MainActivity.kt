package com.example.sportsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        // 2- Data Source
        var sportslist: ArrayList<Sport> = ArrayList()

        val sport1 = Sport(R.drawable.basketball,"BasketBall")
        val sport2 = Sport(R.drawable.football,"Football")
        val sport3 = Sport(R.drawable.ping,"Ping-Pong")
        val sport4 = Sport(R.drawable.volley,"Volley")

        sportslist.add(sport1)
        sportslist.add(sport2)
        sportslist.add(sport3)
        sportslist.add(sport4)

        // 3- Adapter
        val adapter = SportsAdapter(sportslist)
        recyclerView.adapter = adapter

    }
}