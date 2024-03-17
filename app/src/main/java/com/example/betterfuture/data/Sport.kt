package com.example.betterfuture.data

import com.example.betterfuture.R

data class Sport(
    val name: String,
    val quantity: String = "",
    val drawableId: Int,
    val morning: Boolean? = null,
    val midday: Boolean? = null,
    val evening: Boolean? = null
)

val sportList = listOf(
    Sport("running", "13 km", R.drawable.ic_running),
    Sport("Stretching", drawableId = R.drawable.ic_stretching),
    Sport("guenage", "1 min", R.drawable.ic_guenage, true, true, true)
)

