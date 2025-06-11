package com.example.dummy.models

import java.io.Serializable


data class Commentaire (
    var titre: String,
    var message: String,
    var note: Double,
) : Serializable