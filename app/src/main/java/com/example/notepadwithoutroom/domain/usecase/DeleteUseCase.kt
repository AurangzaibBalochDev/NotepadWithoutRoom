package com.example.notepadwithoutroom.domain.usecase

import com.example.notepadwithoutroom.domain.model.NoteEntity
import com.example.notepadwithoutroom.domain.repository.NoteRepository


class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend fun invoke(noteEntity: NoteEntity) {
        repository.delete(noteEntity)
    }
}