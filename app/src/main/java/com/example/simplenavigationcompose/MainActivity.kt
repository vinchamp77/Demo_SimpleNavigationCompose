package com.example.simplenavigationcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.simplenavigationcompose.ui.navigation.BottomBarNav
import com.example.simplenavigationcompose.ui.navigation.NavGraph
import com.example.simplenavigationcompose.ui.navigation.TopBar
import com.example.simplenavigationcompose.ui.theme.SimpleNavComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MainScreen() {
    SimpleNavComposeAppTheme {

        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        val scope =  rememberCoroutineScope()

        Scaffold(
            topBar = { TopBar(
                navController =navController,
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) },
            bottomBar = { BottomBarNav(navController = navController) },
        ) {
            NavGraph(navController)
        }
    }
}
