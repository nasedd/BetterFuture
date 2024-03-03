package com.example.betterfuture.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.betterfuture.data.tabs
import com.example.betterfuture.ui.components.AppBarComponent
import com.example.betterfuture.ui.components.LinearGauge
import com.example.betterfuture.ui.components.TabsComponent
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(){
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabs.size
    }
    LaunchedEffect(selectedIndex){
        pagerState.animateScrollToPage(selectedIndex)
    }
    LaunchedEffect(pagerState.targetPage){
        selectedIndex = pagerState.targetPage
    }

    Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        AppBarComponent()
        TabsComponent(selectedIndex){ index ->
            selectedIndex = index
        }
        HorizontalPager(state = pagerState) { index ->
            when(index){
                0 -> ChatScreen()
                1 -> StatusScreen()
                2 -> Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text("teste 1 -- ------- zzz")
                }
            }
            
        }

        LinearGauge(maxValue = 100f, currentValue = 30f)
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}