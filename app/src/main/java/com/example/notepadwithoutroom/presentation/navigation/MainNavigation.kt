package com.example.notepadwithoutroom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notepadwithoutroom.presentation.add_note.AddNoteScreen
import com.example.notepadwithoutroom.presentation.components.Routes
import com.example.notepadwithoutroom.presentation.note.components.NoteScreen

@Composable
fun MainNavigation (navController: NavHostController){
    NavHost(navController = navController, startDestination = Routes.NoteList.name ){
        composable(Routes.NoteList.name){
            NoteScreen()
        }
        composable("${Routes.AddNote.name}/{noteId}"){
            val noteId = it.arguments?.getString("noteId")
            noteId?.let { id->
                AddNoteScreen(noteId = id.toLong())
            }
        }}
}
