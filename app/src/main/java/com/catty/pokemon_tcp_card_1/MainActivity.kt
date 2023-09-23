package com.catty.pokemon_tcp_card_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.catty.pokemon_tcp_card_1.ui.navigation.Navigation
import com.catty.pokemon_tcp_card_1.ui.theme.JetpackComposePokedexTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launch {
            delay(100)
            setContent {
                JetpackComposePokedexTheme {
                    Navigation()
                }
            }
        }
}

}