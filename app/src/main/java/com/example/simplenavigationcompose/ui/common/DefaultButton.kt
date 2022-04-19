package com.example.simplenavigationcompose.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(5.dp))
    Button(
        onClick = onClick,
        modifier = Modifier.size(width = 200.dp, height = 70.dp)) {
        Text(text, fontSize = 40.sp)
    }
}