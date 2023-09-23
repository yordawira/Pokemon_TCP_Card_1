package com.catty.pokemon_tcp_card_1.ui.pokemonlist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.catty.pokemon_tcp_card_1.ui.pokemonlist.viewmodel.PokemonListViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun PokemonList(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemonList by remember { viewModel.pokemonList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }
    val isSearching by remember { viewModel.isSearching }
    val isRefreshing by remember { viewModel.isRefreshing }

    // Like RecyclerView but in Compose

    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = isRefreshing), onRefresh = {
        viewModel.refresh()
    }) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            val itemCount = if (pokemonList.size % 2 == 0) {
                pokemonList.size / 2
            } else {
                pokemonList.size / 2 + 1
            }
            items(itemCount) {

                // Scroll down, load more Pokémons!
                if (it >= itemCount - 1 && !endReached && !isLoading && !isSearching) {
                    LaunchedEffect(key1 = true) {
                        viewModel.loadPokemonList()
                    }
                }

                PokedexRow(
                    rowIndex = it,
                    entries = pokemonList,
                    navController = navController
                )
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val showDialog = remember { mutableStateOf(false) }

        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }

        if (loadError.isNotEmpty()) {
            showDialog.value = true
        }

        if (showDialog.value) {
            DialogError(error = loadError, onRetry = {
                viewModel.loadPokemonList()
            }, {
                showDialog.value = it
                // TODO: Add disappear effect. Without internet connection,
                //  the error doesn't fade out, and fade in
                //  Seems to be frozen in the middle on the screen and
                //  doesn't give feedback to the user that it's trying again.
            })
        }

    }
}