package com.example.simplenavigationcompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenavigationcompose.ui.screens.destinations.LoginScreenDestination
import com.example.simplenavigationcompose.ui.theme.SimpleNavComposeAppTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    id: Int,
    showDetails: Boolean,
) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Profile Id: $id", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(5.dp))
        Text("Details: $showDetails", fontSize = 40.sp)

        DefaultButton(
            text = "Back",
            onClick = {
                navigator.popBackStack()
            },
        )

        DefaultButton(
            text = "Log Out",
            onClick = {
                navigator.navigate(LoginScreenDestination) {
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
            ProfileScreen(
                navigator = EmptyDestinationsNavigator,
                id = 7,
                showDetails = true,
            )
        }
    }
}