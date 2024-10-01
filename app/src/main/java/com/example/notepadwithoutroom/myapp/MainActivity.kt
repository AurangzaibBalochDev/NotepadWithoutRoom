package com.example.notepadwithoutroom.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notepadwithoutroom.presentation.navigation.MainNavigation
import com.example.notepadwithoutroom.ui.theme.NotepadWithoutRoomTheme

// Create a CompositionLocal for NavHostController
val LocalNavController = compositionLocalOf<NavHostController> {
    error("NavController not provided")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Create NavController with rememberNavController
            val navController = rememberNavController()

            // Provide the NavController to the CompositionLocal
            CompositionLocalProvider(LocalNavController provides navController) {
                NotepadWithoutRoomTheme {
                    MainNavigation(navController = navController)
                }
            }
        }
    }
}