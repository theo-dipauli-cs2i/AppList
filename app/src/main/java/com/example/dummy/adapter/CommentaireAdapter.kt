package com.example.dummy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dummy.R
import com.example.dummy.adapter.ApplicationAdapter.ViewHolder
import com.example.dummy.models.Application
import com.example.dummy.models.Commentaire

class CommentaireAdapter(
    private val context: Context,
    private val commentLayout: Int,
    private val commentaire: List<Commentaire>)
    :  RecyclerView.Adapter<CommentaireAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commentTtile: TextView = itemView.findViewById(R.id.commentTitle)
        val commentMessage: TextView = itemView.findViewById(R.id.comment)
        val commentNote: TextView = itemView.findViewById(R.id.commentNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(commentLayout, parent, false)
        return com.example.dummy.adapter.CommentaireAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = commentaire.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val commentaire = commentaire[position]
        holder.commentTtile.text = commentaire.titre
        holder.commentMessage.text = commentaire.message
        holder.commentNote.text = commentaire.note.toString()
    }
}