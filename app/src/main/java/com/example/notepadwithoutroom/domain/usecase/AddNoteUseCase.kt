package com.example.notepadwithoutroom.domain.usecase

import com.example.notepadwithoutroom.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(title: String, description: String, image: String) {
        repository.insert(title, description, image)
    }

}