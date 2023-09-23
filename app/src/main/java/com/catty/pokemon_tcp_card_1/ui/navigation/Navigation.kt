package com.catty.pokemon_tcp_card_1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.catty.pokemon_tcp_card_1.ui.detail.components.PokemonDetailScreen
import com.catty.pokemon_tcp_card_1.ui.pokemonlist.components.PokemonListScreen
import com.catty.pokemon_tcp_card_1.ui.splash.SplashScreen
import com.catty.pokemon_tcp_card_1.util.Screens
import com.catty.pokemon_tcp_card_1.util.Screens.PokemonDetailScreen
import com.catty.pokemon_tcp_card_1.util.Screens.PokemonListScreen
import com.catty.pokemon_tcp_card_1.util.Screens.SplashScreen
import java.util.Locale

@Composable
fun Navigation() {

    val argPokemonName = "pokemonName"
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen) {
        composable(
            route = Screens.SplashScreen
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screens.PokemonListScreen) {
            PokemonListScreen(navController = navController)
        }
        composable(
            route = "${Screens.PokemonDetailScreen}/{$argPokemonName}",
            arguments = listOf(
                navArgument(argPokemonName) {
                    type = NavType.StringType
                }
            )
        ) {
            val pokemonName = remember {
                it.arguments?.getString(argPokemonName)
            }
            PokemonDetailScreen(
                pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "",
                navController = navController
            )
        }
    }

}