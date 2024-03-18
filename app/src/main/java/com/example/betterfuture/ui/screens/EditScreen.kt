package com.example.betterfuture.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.betterfuture.R
import com.example.betterfuture.data.sportList
import com.example.betterfuture.ui.components.IconComponent
import com.example.betterfuture.ui.components.SportItem

@Composable
fun EditScreen() {
    LazyColumn (
        Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp)){
        for(sport in sportList){
            item {
                Row (verticalAlignment = Alignment.CenterVertically){
                    IconComponent(drawableId = R.drawable.ic_delete)
                    SportItem(sport)
                }

            }
        }
    }
}

@Preview
@Composable
fun EditScreenPreview() {
    EditScreen()
}