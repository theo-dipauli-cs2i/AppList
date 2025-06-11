package com.example.dummy.models

import java.io.Serializable

class Application(
    var nomApplication: String,
    var auteur: String,
    var description: String,
    var note: Double,
    var telechargement: Int,
    var icone: Int,
    var commentaire: MutableList<Commentaire>,
    var isDescriptionVisible: Boolean = false
) : Serializable
