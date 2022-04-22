package com.example.simplenavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.simplenavigationcompose.ui.screens.NavGraphs
import com.example.simplenavigationcompose.ui.theme.SimpleNavComposeAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    SimpleNavComposeAppTheme {
        DestinationsNavHost(navGraph = NavGraphs.root)
    }
}
