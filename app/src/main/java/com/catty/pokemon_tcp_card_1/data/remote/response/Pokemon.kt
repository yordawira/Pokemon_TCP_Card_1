package com.catty.pokemon_tcp_card_1.data.remote.response

data class Pokemon(
    val height: Int,
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)
