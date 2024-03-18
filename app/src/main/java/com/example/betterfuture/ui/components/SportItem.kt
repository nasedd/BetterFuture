package com.example.betterfuture.ui.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.betterfuture.R
import com.example.betterfuture.data.Sport
import com.example.betterfuture.data.sportList

@Composable
fun SportItem(sport: Sport) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            IconComponent(sport.drawableId, modifier = Modifier
                .size(40.dp)
                .padding(end = 4.dp))
            TextComp(text = sport.quantity)
        }
        Spacer(modifier = Modifier.size((20.dp)))
        Row{
            if(sport.morning){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextComp("Matin", Modifier.padding(end = 4.dp))
                    IconImage(R.drawable.ic_box_checked)
                }
            }
            if(sport.midday){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextComp("Midi", Modifier.padding(end = 4.dp))
                    IconImage(R.drawable.ic_box_unchecked)
                }
            }
            if(sport.evening){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextComp("Soir", Modifier.padding(end = 4.dp))
                    IconImage(R.drawable.ic_box_unchecked)
                }
            }

        }


    }

}

@Preview
@Composable
fun SportItemPreview() {
    SportItem(sport = sportList[2])
}