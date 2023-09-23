package com.catty.pokemon_tcp_card_1.ui.detail.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.catty.pokemon_tcp_card_1.data.remote.response.Pokemon
import com.catty.pokemon_tcp_card_1.util.Resource

@Composable
fun PokemonDetailStateWrapper(
    pokemonDetail: Resource<Pokemon>,
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier
) {
    when(pokemonDetail) {
        is Resource.Success -> {
            PokemonDetailSection(
                pokemonDetail = pokemonDetail.data!!,
                modifier = modifier
                    .offset(y = (-20).dp)
            )
        }
        is Resource.Error -> {
            // TODO: Improve, set a message error, maybe a Dialog ?
            Text(
                text = pokemonDetail.message!!,
                color = Color.Red,
                modifier = modifier
            )
        }
        is Resource.Loading -> {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = loadingModifier
            )
        }
    }
}