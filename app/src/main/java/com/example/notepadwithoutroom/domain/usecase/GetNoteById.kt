package com.example.notepadwithoutroom.domain.usecase

import com.example.notepadwithoutroom.domain.model.NoteEntity
import com.example.notepadwithoutroom.domain.repository.NoteRepository


class GetNoteById(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Long): NoteEntity? {
        return repository.getNoteById(id)
    }
}