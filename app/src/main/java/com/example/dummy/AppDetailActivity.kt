package com.example.dummy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.dummy.databinding.ActivityAppDetailBinding
import com.example.dummy.databinding.ItemApplicationBinding

class AppDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_detail)



            binding = ActivityAppDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val appName = intent.getStringExtra("appName")
            val auteur = intent.getStringExtra("auteur")
            val description = intent.getStringExtra("description")
            val note = intent.getDoubleExtra("note", 0.0)
            val telechargement = intent.getIntExtra("telechargement", 0)
            val icone = intent.getIntExtra("icone", 0)

            // Afficher les données
            binding.appName.text = appName
            binding.auteurName.text = auteur
            binding.description.text = description
            binding.note.text = note.toString()
            binding.download.text = telechargement.toString()
            binding.appImage.setImageResource(icone)

           binding.backButton.setOnClickListener {
                onBackPressed()
            }
        }
    }