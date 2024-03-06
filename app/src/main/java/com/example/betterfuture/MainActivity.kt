package com.example.betterfuture

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import com.example.betterfuture.ExoPlayerSingleton.player
import com.example.betterfuture.ui.screens.HomeScreen
import com.example.betterfuture.ui.theme.BetterFutureTheme

object ExoPlayerSingleton {
    var player: ExoPlayer? = null

}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = ExoPlayer.Builder(this).build()
        val path = "android.resource://" + packageName + "/" + R.raw.coherence_cardiaque
        val mediaItem = MediaItem.fromUri(Uri.parse(path))
        player?.addMediaItem(mediaItem)
        player?.prepare()
        //val mediaSession = MediaSession.Builder(this, player!!).build()


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