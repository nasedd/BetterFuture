package com.example.betterfuture.data

data class User(
    val name: String,
    val age: Int,
    val currentSteps: Int,
    val goalStep: Int = 5000
)

val users = listOf(
    User("Norah Seddaoui", 55, 3600,10000),
    User("Farez Hoseni", 30, 111),
    User("Djamila Seddaoui", 55, 5200)
)
/*
User("Imane Azeddine", 55, 1305),
    User("Nadir Seddaoui", 30, 10000),
    User("Jalil Bessaoudi", 18, 10000)
* */