package com.example.betterfuture.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterfuture.R


@Composable
fun StatusItem(name: String){
    Row (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(4.dp)
    ) {
        Column(Modifier.width(60.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary)

            )
            TextComp(
                text = "Imane Azeddine",
                modifier = Modifier.width(IntrinsicSize.Max)
            )
        }

        //Spacer(modifier = Modifier.size(4.dp))
        Column {
            Row {
                LinearGauge(maxValue = 100f, currentValue = 30f, gaugeHeight = 10.dp, modifier = Modifier.padding(end = 8.dp))
                TextComp("4300 pas")
            }
            Row (verticalAlignment = Alignment.CenterVertically){
                IconComponent(R.drawable.ic_breath, modifier = Modifier.padding(end = 4.dp))
                TextComp("Matin")
                IconComponent(R.drawable.ic_box_checked, modifier = Modifier.padding(end = 4.dp))
                
                IconComponent(R.drawable.ic_breath, modifier = Modifier.padding(end = 4.dp))
                TextComp("Midi")
                IconComponent(R.drawable.ic_box_unchecked, modifier = Modifier.padding(end = 4.dp))

                IconComponent(R.drawable.ic_breath, modifier = Modifier.padding(end = 4.dp))
                TextComp("Soir")
                IconComponent(R.drawable.ic_box_unchecked, modifier = Modifier.padding(end = 4.dp))            }

            Row (verticalAlignment = Alignment.CenterVertically){
                IconComponent(R.drawable.ic_sport, modifier = Modifier.padding(end = 4.dp))
                IconComponent(R.drawable.ic_box_checked, modifier = Modifier.padding(end = 4.dp))

                IconComponent(R.drawable.ic_stretching, modifier = Modifier.padding(end = 4.dp))
                IconComponent(R.drawable.ic_box_unchecked, modifier = Modifier.padding(end = 4.dp))            }


        }

    }
}

@Composable
fun TextComp(text: String, modifier: Modifier = Modifier){
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        ),
        textAlign = TextAlign.Center
    )
}



@Preview
@Composable
fun StatusItemPreview() {
    StatusItem("El Bosso del Rio")
}