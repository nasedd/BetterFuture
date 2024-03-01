package com.example.betterfuture.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun IconComponent(
    drawableId: Int,
    modifier: Modifier = Modifier,
){
    Icon(
        modifier = modifier,
        painter = painterResource(id = drawableId),
        contentDescription = "",
        tint = MaterialTheme.colorScheme.onBackground
    )
}