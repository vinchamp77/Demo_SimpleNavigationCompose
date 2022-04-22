package com.example.simplenavigationcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.simplenavigationcompose.ui.screens.destinations.LoginScreenDestination
import com.example.simplenavigationcompose.ui.screens.destinations.ProfileScreenDestination
import com.example.simplenavigationcompose.ui.screens.destinations.SearchScreenDestination
import com.example.simplenavigationcompose.ui.theme.SimpleNavComposeAppTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator?
) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Home Screen", fontSize = 40.sp)

        DefaultButton(
            text = "Profile",
            onClick = {
                navigator?.navigate(ProfileScreenDestination(7, true))
            },
        )

        DefaultButton(
            text = "Search",
            onClick = {
               navigator?.navigate(SearchScreenDestination("liang moi"))
            },
        )

        DefaultButton(
            text = "Back",
            onClick = {
                navigator?.popBackStack()
            },
        )

        DefaultButton(
            text = "Log Out",
            onClick = {
               navigator?.navigate(LoginScreenDestination) {
                   popUpTo(LoginScreenDestination.route) {inclusive = true}
               }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SimpleNavComposeAppTheme(useSystemUiController = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(navigator = null)
       }
    }
}