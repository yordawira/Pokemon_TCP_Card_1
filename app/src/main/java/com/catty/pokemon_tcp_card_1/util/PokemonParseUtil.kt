package com.catty.pokemon_tcp_card_1.util

import androidx.compose.ui.graphics.Color
import com.catty.pokemon_tcp_card_1.data.remote.response.Stat
import com.catty.pokemon_tcp_card_1.data.remote.response.Type
import com.catty.pokemon_tcp_card_1.ui.theme.AtkColor
import com.catty.pokemon_tcp_card_1.ui.theme.DefColor
import com.catty.pokemon_tcp_card_1.ui.theme.HPColor
import com.catty.pokemon_tcp_card_1.ui.theme.SpAtkColor
import com.catty.pokemon_tcp_card_1.ui.theme.SpDefColor
import com.catty.pokemon_tcp_card_1.ui.theme.SpdColor
import com.catty.pokemon_tcp_card_1.ui.theme.TypeBug
import com.catty.pokemon_tcp_card_1.ui.theme.TypeDark
import com.catty.pokemon_tcp_card_1.ui.theme.TypeDragon
import com.catty.pokemon_tcp_card_1.ui.theme.TypeElectric
import com.catty.pokemon_tcp_card_1.ui.theme.TypeFairy
import com.catty.pokemon_tcp_card_1.ui.theme.TypeFighting
import com.catty.pokemon_tcp_card_1.ui.theme.TypeFire
import com.catty.pokemon_tcp_card_1.ui.theme.TypeFlying
import com.catty.pokemon_tcp_card_1.ui.theme.TypeGhost
import com.catty.pokemon_tcp_card_1.ui.theme.TypeGrass
import com.catty.pokemon_tcp_card_1.ui.theme.TypeGround
import com.catty.pokemon_tcp_card_1.ui.theme.TypeIce
import com.catty.pokemon_tcp_card_1.ui.theme.TypeNormal
import com.catty.pokemon_tcp_card_1.ui.theme.TypePoison
import com.catty.pokemon_tcp_card_1.ui.theme.TypePsychic
import com.catty.pokemon_tcp_card_1.ui.theme.TypeRock
import com.catty.pokemon_tcp_card_1.ui.theme.TypeSteel
import com.catty.pokemon_tcp_card_1.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when (type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when (stat.stat.name.lowercase(Locale.ROOT)) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when (stat.stat.name.lowercase(Locale.ROOT)) {
        "hp" -> "Hp"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "Sp.Atk"
        "special-defense" -> "Sp.Def"
        "speed" -> "Spd"
        else -> ""
    }
}