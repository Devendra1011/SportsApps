package com.example.sportsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class SportsAdapter(val sportsList: ArrayList<Sport>) :
    RecyclerView.Adapter<SportsAdapter.SportViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        // Create and return a new ViewHolder Instance for each Item
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout,parent,false)
        return SportViewHolder(v)

    }

    override fun getItemCount(): Int {
        // Returns the total number of items in the dataset
        return sportsList.size
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        // Bind Data to views based ion the item at the specified position
        holder.sportsImage.setImageResource(sportsList[position].sportImage)
        holder.sportsName.setText(sportsList[position].sportName)
    }

    // ViewHolder: Holds the references to the views within
    // each item in the recyclerview
    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sportsImage: ImageView
        var sportsName: TextView
        init {
            sportsImage = itemView.findViewById(R.id.cil_iv_sportImage)
            sportsName = itemView.findViewById(R.id.cil_tv_sportName)

            // Handling CLickEvents
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,"You Clicked: ${sportsList[adapterPosition].sportName}",Toast.LENGTH_SHORT).show()

            }
        }
    }
}