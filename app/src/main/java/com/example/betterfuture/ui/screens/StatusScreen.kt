package com.example.betterfuture.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.betterfuture.data.users
import com.example.betterfuture.ui.components.StatusItem

@Composable
fun StatusScreen() {
    LazyColumn {
        for(user in users){
            item {
                StatusItem(name = user.name)
                Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
            }
        }
    }
}

@Preview
@Composable
fun StatusScreenPreview() {
    StatusScreen()
}