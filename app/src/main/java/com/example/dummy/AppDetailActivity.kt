package com.example.dummy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummy.adapter.ApplicationAdapter
import com.example.dummy.adapter.CommentaireAdapter
import com.example.dummy.databinding.ActivityAppDetailBinding
import com.example.dummy.models.Application

class AppDetailActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityAppDetailBinding = ActivityAppDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val application = intent.getSerializableExtra("application") as? Application
        displayComment(application, binding)

        setContentView(binding.root)



        val appName = application?.nomApplication
        val auteur = application?.auteur
        val description = application?.description
        val note = application?.note
        val telechargement = application?.telechargement
        val icone = application?.icone

        binding.appName.text = appName
        binding.auteurName.text = auteur
        binding.description.text = description
        binding.note.text = note.toString()
        binding.download.text = telechargement.toString()
        if (icone != null) {
            binding.appImage.setImageResource(icone)
        }

       binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }

    fun displayComment(application : Application?, binding: ActivityAppDetailBinding) {
        val commentRecyclerView = binding.commentaireView
        val commentAdapter = application?.let {
            CommentaireAdapter(
                this,
                R.layout.comment_application,
                application.commentaire
            )
        }
        commentRecyclerView.adapter = commentAdapter
        commentRecyclerView.layoutManager = LinearLayoutManager(this)
    }

}