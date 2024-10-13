package com.example.amtoon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mangaitemdataclass


// Adapter class for RecyclerView
class MangaitemAdapter(private val eventdata: List<mangaitemdataclass>) :
    RecyclerView.Adapter<MangaitemAdapter.EventViewHolder>() {

    // ViewHolder class
    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.Image)
        val creator: TextView = itemView.findViewById(R.id.Creator)
        val episode: TextView = itemView.findViewById(R.id.episodes)
        val reads: TextView = itemView.findViewById(R.id.Reads)
        val release: TextView = itemView.findViewById(R.id.Release)
        val title: TextView = itemView.findViewById(R.id.title)
        val moreInfo: ImageView = itemView.findViewById(R.id.moreinfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mangaitem, parent, false)
        return EventViewHolder(view)
    }

    override fun getItemCount(): Int {
        return eventdata.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentItem = eventdata[position]

        // Set data to views
        holder.title.text = currentItem.title // Assuming title is displayed as is
        holder.creator.text = "Creator: ${currentItem.creator}" // Prefixed with "Creator:"
        holder.episode.text = "Episodes: ${currentItem.episodes}" // Prefixed with "Episodes:"
        holder.reads.text = "Reads: ${currentItem.reads}" // Prefixed with "Reads:"
        holder.release.text = "Release Date: ${currentItem.release}" // Prefixed with "Release Date:"
// Ensure title is displayed

        // Loading the image using Glide
        Glide.with(holder.itemView.context)
            .load(currentItem.imageLink)
            .into(holder.image)


        holder.moreInfo.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailedmangainfoActivity::class.java).apply {
                putExtra("MANGA_TITLE", currentItem.title)
                putExtra("MANGA_CREATOR", currentItem.creator)
                putExtra("MANGA_RELEASE_DATE", currentItem.release)
                putExtra("MANGA_EPISODES", currentItem.episodes)
                putExtra("MANGA_READS", currentItem.reads)
                putExtra("MANGA_IMAGE_LINK", currentItem.imageLink)
                putExtra("MANGA_DESCRIPTION", currentItem.description)
            }
            context.startActivity(intent)
        }
    }
}
