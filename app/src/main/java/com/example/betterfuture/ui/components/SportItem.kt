package com.example.betterfuture.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.betterfuture.R
import com.example.betterfuture.data.Sport
import com.example.betterfuture.data.sportList

@Composable
fun SportItem(sport: Sport) {
    Row {
        IconImage(sport.drawableId, modifier = Modifier.padding(end = 6.dp))
    }
}

@Preview
@Composable
fun SportItemPreview() {
    SportItem(sport = sportList[2])
}