package com.catty.pokemon_tcp_card_1.data.remote

import com.catty.pokemon_tcp_card_1.data.remote.response.Pokemon
import com.catty.pokemon_tcp_card_1.data.remote.response.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeAPI {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): Pokemon
}