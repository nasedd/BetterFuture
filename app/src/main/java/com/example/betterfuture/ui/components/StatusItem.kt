package com.example.betterfuture.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterfuture.R
import com.example.betterfuture.ui.screens.ChatScreen


@Composable
fun StatusItem(name: String){
    Row (
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
                .background(color = MaterialTheme.colorScheme.primary)

        )
        Spacer(modifier = Modifier.size(4.dp))
        Column {
            Row {
                LinearGauge(maxValue = 100f, currentValue = 30f)
                Text(text = "4300 pas")
            }
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Respiration",
                    fontSize = 8.sp
                    )
                Checkbox(checked = true, onCheckedChange = {})
                Text(
                    text = "sport",
                    fontSize = 8.sp
                )
                Checkbox(checked = false, onCheckedChange = {})
            }


        }

    }
}



@Preview
@Composable
fun StatusItemPreview() {
    StatusItem("El Bosso del Rio")
}