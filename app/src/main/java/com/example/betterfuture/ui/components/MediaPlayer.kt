package com.example.betterfuture.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.betterfuture.ExoPlayerSingleton.player
import com.example.betterfuture.R
import kotlinx.coroutines.delay


val playerWidth = 250.dp

@Composable
fun MediaPlayer() {
    val isPlaying = remember {
        mutableStateOf(false)
    }

    val currentPosition = remember {
        mutableLongStateOf(0)
    }

    val sliderPosition = remember {
        mutableLongStateOf(0)
    }

    val totalDuration = remember {
        mutableLongStateOf(0)
    }


    LaunchedEffect(key1 = player.currentPosition, key2 = player.isPlaying) {
        delay(1000)
        currentPosition.longValue = player.currentPosition
    }

    LaunchedEffect(currentPosition.longValue) {
        sliderPosition.longValue = currentPosition.longValue
    }

    LaunchedEffect(player.duration) {
        if (player.duration > 0) {
            totalDuration.longValue = player.duration
        }
    }


    Column(horizontalAlignment = Alignment.End) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconComponent(
                drawableId = if (isPlaying.value) R.drawable.ic_pause else R.drawable.ic_play,
                modifier = Modifier
                    .size(50.dp)
                    .padding(2.dp)
                    .clickable {
                        if (isPlaying.value) {
                            player.pause()
                        } else {
                            player.play()
                        }
                        isPlaying.value = player.isPlaying
                    })
            Spacer(modifier = Modifier.size(4.dp))

            TrackSlider(
                value = sliderPosition.longValue.toFloat(),
                onValueChange = {
                    sliderPosition.longValue = it.toLong()
                },
                onValueChangeFinished = {
                    currentPosition.longValue = sliderPosition.longValue
                    player.seekTo(sliderPosition.longValue)
                },
                songDuration = totalDuration.longValue.toFloat(),
                modifier = Modifier
                    .width(playerWidth)
                    .padding(0.dp)
                    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
            )

        }

        Row(
            modifier = Modifier.width(playerWidth),
            verticalAlignment = Alignment.Top
        ) {

            Text(
                text = (currentPosition.longValue).convertToText(),
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            val remainTime = totalDuration.longValue - currentPosition.longValue
            Text(
                text = if (remainTime >= 0) remainTime.convertToText() else "",
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackSlider(
    value: Float,
    onValueChange: (newValue: Float) -> Unit,
    onValueChangeFinished: () -> Unit,
    songDuration: Float,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        Slider(
            modifier = modifier,
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            onValueChangeFinished = {
                onValueChangeFinished()
            },
            valueRange = 0f..songDuration,
            colors = SliderDefaults.colors(
                thumbColor = Color.Black,
                activeTrackColor = Color.DarkGray,
                inactiveTrackColor = Color.Gray,
            )
        )
    }

}

fun Long.convertToText(): String {
    val sec = this / 1000
    val minutes = sec / 60
    val seconds = sec % 60

    val minutesString = if (minutes < 10) {
        "0$minutes"
    } else {
        minutes.toString()
    }
    val secondsString = if (seconds < 10) {
        "0$seconds"
    } else {
        seconds.toString()
    }
    return "$minutesString:$secondsString"
}

@Preview
@Composable
fun MediaPlayerPreview() {
    MediaPlayer()
}