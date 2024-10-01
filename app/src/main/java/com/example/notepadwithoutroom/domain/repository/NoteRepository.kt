package com.example.notepadwithoutroom.domain.repository

import com.example.notepadwithoutroom.domain.model.NoteEntity
import java.util.concurrent.Flow

interface NoteRepository {
    suspend fun insert (title:String,description:String,image:String)
    suspend fun update (id:Long,title:String,description:String,image:String)
    suspend fun delete(noteEntity: NoteEntity)
    suspend fun getNoteById(id:Long):NoteEntity?
    fun getNotes(): kotlinx.coroutines.flow.Flow<List<NoteEntity>>
}