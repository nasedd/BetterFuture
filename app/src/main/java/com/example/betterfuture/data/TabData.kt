package com.example.betterfuture.data

data class TabData(
    val title: String,
    val unreadCount: Int?
)

val tabs = listOf(
    TabData(Tabs.CHATS.value, 5),
    TabData(Tabs.STATUS.value, null),
    TabData(Tabs.CALLS.value, 24)
)

enum class Tabs(val value: String){
    CHATS("Chats"),
    STATUS("Status"),
    CALLS("Calls")
}
