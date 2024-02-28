package com.example.betterfuture.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.betterfuture.ui.components.AppBarComponent
import com.example.betterfuture.ui.components.LinearGauge
import com.example.betterfuture.ui.components.TabsComponent

@Composable
fun HomeScreen(){
    Column {
        AppBarComponent()
        TabsComponent()
        ChatScreen()
        LinearGauge(maxValue = 100f, currentValue = 30f)
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}