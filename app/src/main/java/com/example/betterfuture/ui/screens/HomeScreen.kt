package com.example.betterfuture.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.betterfuture.ui.components.AppBarComponent

@Composable
fun HomeScreen(){
    Column {
        AppBarComponent()
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}