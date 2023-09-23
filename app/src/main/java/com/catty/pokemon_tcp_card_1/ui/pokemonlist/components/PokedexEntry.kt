package com.catty.pokemon_tcp_card_1.ui.pokemonlist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.catty.pokemon_tcp_card_1.data.models.PokedexListEntry
import com.catty.pokemon_tcp_card_1.ui.pokemonlist.viewmodel.PokemonListViewModel
import com.catty.pokemon_tcp_card_1.ui.theme.Roboto
import com.catty.pokemon_tcp_card_1.util.Screens

@Composable
fun PokedexEntry(
    entry: PokedexListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel()
) {

    val roundedCornerSize = 16.dp

    Card (
        modifier = modifier
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(roundedCornerSize)
            )
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(roundedCornerSize))
            .clickable {
                navController.navigate(
                    "${Screens.PokemonDetailScreen}/${entry.pokemonName}"
                )
            }
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
        ) {
            val topAndBottomMargin = 12.dp
            Spacer(modifier = Modifier.height(topAndBottomMargin))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(entry.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = entry.pokemonName,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "#${entry.number}",
                fontFamily = Roboto,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp, 8.dp, 0.dp)
            )
            // TODO: Max 2 lines, enable ellipsize
            Text(
                text = entry.pokemonName,
                fontFamily = Roboto,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(topAndBottomMargin))
        }
    }
}