package com.example.notepadwithoutroom.domain.usecase

import com.example.notepadwithoutroom.domain.repository.NoteRepository

class UpdateNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Long, title: String, description: String,image:String) {
        repository.update(
            id = id,
            title = title,
            description = description,
            image = image
        )
    }
}