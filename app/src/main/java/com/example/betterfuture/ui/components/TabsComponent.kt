package com.example.betterfuture.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterfuture.data.TabData
import com.example.betterfuture.data.tabs

@Composable
fun TabsComponent(selectedIndex: Int, onClickTab: (Int) -> Unit) {

    val tabColor = if(isSystemInDarkTheme()){
        MaterialTheme.colorScheme.secondary
    } else {
        MaterialTheme.colorScheme.primary
    }

    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = Modifier.fillMaxWidth(),
        containerColor = tabColor,
        contentColor = MaterialTheme.colorScheme.tertiary,
        indicator = {tabPosition ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPosition[selectedIndex]),
                color = MaterialTheme.colorScheme.tertiary,
                height = 6.dp
            )
        }
    ) {

        tabs.forEachIndexed { index, tabData ->
            Tab(
                selected = index == selectedIndex,
                onClick = {
                    onClickTab(index)
                },
                text = {
                    TabContent(
                        tabData = tabData,
                        isSelected = index == selectedIndex
                    )
                }
            )
        }
    }
}

@Composable
fun TabContent(tabData: TabData, isSelected: Boolean){
    if(tabData.unreadCount == null){
        TabTitle(title = tabData.title, isSelected)
    }else {
        TabWithUnreadCount(tabData, isSelected)
    }
}

@Composable
fun TabTitle(title: String, isSelected: Boolean){
    Text(
        text = title,
        style = TextStyle(
            fontSize = 16.sp,
            color = if (isSelected) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.tertiary
        )
    )
}

@Composable
fun TabWithUnreadCount(tabData: TabData, isSelected: Boolean){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        TabTitle(tabData.title, isSelected)

        tabData.unreadCount?.let {
            Text(
                text = it.toString(),
                modifier = Modifier
                    .padding(6.dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.tertiary
                    ),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun TabsComponentPreview() {
    TabsComponent(0) {}
}