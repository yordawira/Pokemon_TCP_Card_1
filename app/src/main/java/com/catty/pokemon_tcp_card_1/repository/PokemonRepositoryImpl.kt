package com.catty.pokemon_tcp_card_1.repository

import com.catty.pokemon_tcp_card_1.data.remote.PokeAPI
import com.catty.pokemon_tcp_card_1.data.remote.response.Pokemon
import com.catty.pokemon_tcp_card_1.data.remote.response.PokemonList
import com.catty.pokemon_tcp_card_1.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeAPI
): PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An error occurred.")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonDetail(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An error occurred.")
        }
        return Resource.Success(response)
    }

}