package com.example.dummy.models

class Application(
    var nomApplication: String,
    var auteur: String,
    var description: String,
    var note: Double,
    var telechargement: Int,
    var icone: Int,
    var isDescriptionVisible : Boolean = false
)
