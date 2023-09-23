package com.catty.pokemon_tcp_card_1.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.catty.pokemon_tcp_card_1.data.remote.response.Pokemon
import com.catty.pokemon_tcp_card_1.repository.PokemonRepositoryImpl
import com.catty.pokemon_tcp_card_1.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepositoryImpl
): ViewModel() {

    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonDetail(pokemonName)
    }

}