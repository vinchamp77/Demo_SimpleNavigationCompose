package com.example.simplenavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.simplenavigationcompose.ui.navigation.BottomBarNav
import com.example.simplenavigationcompose.ui.navigation.NavGraph
import com.example.simplenavigationcompose.ui.theme.SimpleNavComposeAppTheme

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

        val navController = rememberNavController()

        Scaffold(
            bottomBar = { BottomBarNav(navController = navController) }
        ) { paddingValues ->
            NavGraph(
                modifier = Modifier.padding(
                    bottom = paddingValues.calculateBottomPadding()),
                navController = navController
            )
        }
    }
}
