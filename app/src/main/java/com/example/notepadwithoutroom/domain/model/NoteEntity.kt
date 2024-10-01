package com.example.notepadwithoutroom.domain.model

import java.util.Calendar

data class NoteEntity(
    val id: Long =Calendar.getInstance().timeInMillis,
    val image: String="",
    val title: String,
    val description: String,
)