package com.example.betterfuture.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
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
import com.example.betterfuture.data.sportList
import com.example.betterfuture.data.users
import com.example.betterfuture.ui.components.IconComponent
import com.example.betterfuture.ui.components.IconImage
import com.example.betterfuture.ui.components.LinearGauge
import com.example.betterfuture.ui.components.MediaPlayer
import com.example.betterfuture.ui.components.SportItem
import com.example.betterfuture.ui.components.StatusItem
import com.example.betterfuture.ui.components.TextComp

@Composable
fun PersoScreen() {

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.size(10.dp))
        Row (){
            TextTitlePerso(text = "1148 pas", modifier = Modifier.padding(8.dp))
            IconComponent(R.drawable.ic_foot_print,
                Modifier
                    .size(34.dp)
                    .padding(top = 8.dp))
        }
        LinearGauge(maxValue = 100f, currentValue = 30f, gaugeHeight = 30.dp, gaugeWidth = 300.dp, modifier = Modifier.padding(bottom = 8.dp))
        Spacer(modifier = Modifier.size(20.dp))
        Divider(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            color = MaterialTheme.colorScheme.primary,
            thickness = 2.dp
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row{
            TextTitlePerso(text = "Respiration")
            IconComponent(R.drawable.ic_breath, modifier = Modifier.padding(start = 8.dp))
        }

        MediaPlayer()

        Spacer(modifier = Modifier.size(20.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(verticalAlignment = Alignment.CenterVertically){
                TextComp("Matin", Modifier.padding(end = 4.dp))
                IconImage(R.drawable.ic_box_checked)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextComp("Midi", Modifier.padding(end = 4.dp))
                IconImage(R.drawable.ic_box_unchecked)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextComp("Soir", Modifier.padding(end = 4.dp))
                IconImage(R.drawable.ic_box_unchecked)
            }

        }

        Spacer(modifier = Modifier.size(20.dp))
        Divider(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            color = MaterialTheme.colorScheme.primary,
            thickness = 2.dp
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextTitlePerso(text = "Sport")
        Spacer(modifier = Modifier.size(20.dp))

        LazyColumn (Modifier.fillMaxSize()){
            for(sport in sportList){
                item {
                    SportItem(sport)
                }
            }
        }

        Row (verticalAlignment = Alignment.CenterVertically){
            IconComponent(R.drawable.ic_running, modifier = Modifier.padding(end = 2.dp))
            IconImage(R.drawable.ic_box_checked, modifier = Modifier.padding(end = 6.dp))

            IconComponent(R.drawable.ic_stretching, modifier = Modifier.padding(end = 2.dp))
            IconImage(R.drawable.ic_box_unchecked, modifier = Modifier.padding(end = 6.dp))            }


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