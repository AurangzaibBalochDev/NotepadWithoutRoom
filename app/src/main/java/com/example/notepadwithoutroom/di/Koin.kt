package com.example.notepadwithoutroom.di

import com.example.notepadwithoutroom.data.communicator.Communicator
import com.example.notepadwithoutroom.data.repository.NoteRepositoryImp
import com.example.notepadwithoutroom.domain.repository.NoteRepository
import com.example.notepadwithoutroom.domain.usecase.AddNoteUseCase
import com.example.notepadwithoutroom.domain.usecase.DeleteNoteUseCase
import com.example.notepadwithoutroom.domain.usecase.GetNoteById
import com.example.notepadwithoutroom.domain.usecase.GetNoteUsesCase
import com.example.notepadwithoutroom.domain.usecase.UpdateNoteUseCase
import com.example.notepadwithoutroom.presentation.add_note.AddNoteViewModel
import com.example.notepadwithoutroom.presentation.note.NoteViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleList = module {
    single {
        //Make Communicator Singleton
        Communicator()
    }
    viewModel {
        NoteViewModel(get(), get())
    }
    viewModel {
        AddNoteViewModel(get(), get(), get())
    }
    factory<NoteRepository> {
        NoteRepositoryImp(get())
    }
    factory {
        AddNoteUseCase(get())
    }
    factory {
        DeleteNoteUseCase(get())
    }
    factory {
        GetNoteUsesCase(get())
    }
    factory {
        GetNoteById(get())
    }
    factory {
        UpdateNoteUseCase(get())
    }
}