package com.example.notepadwithoutroom.presentation.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepadwithoutroom.domain.model.NoteEntity
import com.example.notepadwithoutroom.domain.usecase.DeleteNoteUseCase
import com.example.notepadwithoutroom.domain.usecase.GetNoteUsesCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



data class NoteState(
    val itemsList: List<NoteEntity> = emptyList()
)

class NoteViewModel(
    private val getNotesUseCase: GetNoteUsesCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(NoteState())
    val state = _state.asStateFlow()

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            getNotesUseCase().collectLatest { note ->
                _state.update { noteState ->
                    noteState.copy(
                        itemsList = note
                    )
                }
            }
        }
    }

    fun onDelete(noteEntity: NoteEntity) {
        viewModelScope.launch {
            deleteNoteUseCase.invoke(noteEntity)
        }
    }

    fun onShuffle() {
        viewModelScope.launch {
            val itemsList = _state.value.itemsList.shuffled()
            _state.update { noteState ->
                noteState.copy(
                    itemsList = itemsList
                )
            }
        }
    }
}