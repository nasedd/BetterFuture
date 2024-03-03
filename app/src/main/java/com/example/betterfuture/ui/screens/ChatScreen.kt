package com.example.betterfuture.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.betterfuture.R
import com.example.betterfuture.data.users

@Composable
fun ChatScreen() {

    LazyColumn(Modifier.fillMaxSize()) {
        for(user in users){
            item {
                ContactItem(name = user.name)
                Divider(color = MaterialTheme.colorScheme.primary, thickness = 2.dp)
            }
        }
    }
}

@Composable
fun ContactItem(name: String){
    Row (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(

            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp)
                .background(color = MaterialTheme.colorScheme.primary)

        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = name,
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        )
    }
}



@Preview
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}