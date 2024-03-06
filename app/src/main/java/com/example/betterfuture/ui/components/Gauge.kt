package com.example.betterfuture.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun LinearGauge(
    maxValue: Float,
    currentValue: Float,
    gaugeWidth: Dp = 200.dp,
    gaugeHeight: Dp = 20.dp,
    modifier: Modifier = Modifier
) {
    // Couleur de l'arrière-plan de la jauge
    val backgroundColor = MaterialTheme.colorScheme.secondary

    // Couleur de la jauge
    val gaugeColor = MaterialTheme.colorScheme.primary

    Box(modifier = modifier.height(gaugeHeight).width(gaugeWidth)) {
        Canvas(modifier = Modifier.fillMaxWidth()) {
            val width = gaugeWidth.toPx()
            val height = gaugeHeight.toPx()

            // Dessin de l'arrière-plan de la jauge
            drawRoundRect(
                color = backgroundColor,
                topLeft = Offset(0f, 0f),
                size = Size(width, height),
                cornerRadius = CornerRadius(height / 2)
            )

            // Calcul de la largeur de la jauge en fonction de la valeur actuelle et maximale
            val fillWidth = (currentValue / maxValue) * width

            // Dessin de la jauge
            drawRoundRect(
                color = gaugeColor,
                topLeft = Offset(0f, 0f),
                size = Size(max(0f, fillWidth), height),
                cornerRadius = CornerRadius(height / 2)
            )
        }
    }
}
@Preview
@Composable
fun GaugePreview(){
    LinearGauge(maxValue = 100f, currentValue = 30f)
}