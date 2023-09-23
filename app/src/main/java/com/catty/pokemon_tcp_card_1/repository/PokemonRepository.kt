package com.catty.pokemon_tcp_card_1.repository

import com.catty.pokemon_tcp_card_1.data.remote.response.Pokemon
import com.catty.pokemon_tcp_card_1.data.remote.response.PokemonList
import com.catty.pokemon_tcp_card_1.util.Resource

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>
    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon>
}