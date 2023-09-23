package com.catty.pokemon_tcp_card_1.ui.pokemonlist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.catty.pokemon_tcp_card_1.ui.pokemonlist.viewmodel.PokemonListViewModel
import com.google.android.material.search.SearchBar

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            // TODO: Search bar in collapsing toolbar
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
                    .padding(8.dp),
                hint = "Search...",
            ) {
                viewModel.searchPokemonList(it)
            }
            PokemonList(navController = navController)
        }
    }
}

