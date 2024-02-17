package com.example.betterfuture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.betterfuture.ui.screens.HomeScreen
import com.example.betterfuture.ui.theme.BetterFutureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterFutureTheme {
                HomeScreen()
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun BetterFuturePreview() {
    BetterFutureTheme {
        HomeScreen()
    }
}