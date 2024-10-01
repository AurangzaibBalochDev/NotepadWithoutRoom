package com.example.notepadwithoutroom.domain.usecase

import com.example.notepadwithoutroom.domain.model.NoteEntity
import com.example.notepadwithoutroom.domain.repository.NoteRepository
import java.util.concurrent.Flow

class GetNoteUsesCase
    (private val repository: NoteRepository) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<List<NoteEntity>> {
        return repository.getNotes()
    }
}