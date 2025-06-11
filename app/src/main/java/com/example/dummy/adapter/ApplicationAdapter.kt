package com.example.dummy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dummy.R
import com.example.dummy.models.Application
import androidx.core.view.isVisible

class ApplicationAdapter(
    private val context: Context,
    private val itemLayout: Int,
    private val applications: List<Application>
) : RecyclerView.Adapter<ApplicationAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val appIcone: ImageView = itemView.findViewById(R.id.appImage)
        val appName: TextView = itemView.findViewById(R.id.appName)
        val auteurName: TextView = itemView.findViewById(R.id.auteurName)
        val download: TextView = itemView.findViewById(R.id.download)
        val note: TextView = itemView.findViewById(R.id.note)
        val description: TextView = itemView.findViewById(R.id.description)
        val detailButton: TextView = itemView.findViewById(R.id.detailButton)
    }



    // Méthode pour créer les ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    // Méthode pour lier les données aux ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val application = applications[position]
        holder.appName.text = application.nomApplication
        holder.auteurName.text = application.auteur
        holder.download.text = application.telechargement.toString()
        holder.note.text = application.note.toString()
        holder.appIcone.setImageResource(application.icone)
        holder.description.text = application.description
        holder.description.visibility = View.GONE
        holder.detailButton.visibility = View.GONE
        holder.itemView.setOnClickListener {
            if (holder.description.isVisible) {
                holder.description.visibility = View.GONE
                holder.detailButton.visibility = View.GONE
            } else {
                holder.description.visibility = View.VISIBLE
                holder.detailButton.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int = applications.size
}
