package com.example.betterfuture.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterfuture.R
import com.example.betterfuture.ui.components.IconComponent
import com.example.betterfuture.ui.components.IconTheme
import com.example.betterfuture.ui.components.LinearGauge
import com.example.betterfuture.ui.components.TextComp

@Composable
fun PersoScreen() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextTitlePerso(text = "1148 pas", modifier = Modifier.padding(8.dp))
        LinearGauge(maxValue = 100f, currentValue = 30f, gaugeHeight = 30.dp, gaugeWidth = 300.dp, modifier = Modifier.padding(bottom = 8.dp))
        Spacer(modifier = Modifier.size(20.dp))

        TextTitlePerso(text = "Respiration")

        Row (verticalAlignment = Alignment.CenterVertically){
            IconComponent(R.drawable.ic_breath, modifier = Modifier.padding(end = 4.dp))
            TextComp("Matin")
            IconTheme(R.drawable.ic_box_checked, modifier = Modifier.padding(end = 6.dp))

            TextComp("Midi")
            IconTheme(R.drawable.ic_box_unchecked, modifier = Modifier.padding(end = 6.dp))


            TextComp("Soir")
            IconTheme(R.drawable.ic_box_unchecked, modifier = Modifier.padding(end = 4.dp))
        }

        Row (verticalAlignment = Alignment.CenterVertically){
            IconComponent(R.drawable.ic_sport, modifier = Modifier.padding(end = 2.dp))
            IconTheme(R.drawable.ic_box_checked, modifier = Modifier.padding(end = 6.dp))

            IconComponent(R.drawable.ic_stretching, modifier = Modifier.padding(end = 2.dp))
            IconTheme(R.drawable.ic_box_unchecked, modifier = Modifier.padding(end = 6.dp))            }


    }
}

@Composable
fun TextTitlePerso(text: String, modifier: Modifier = Modifier){
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        ),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PersoScreenPreview() {
    PersoScreen()
}