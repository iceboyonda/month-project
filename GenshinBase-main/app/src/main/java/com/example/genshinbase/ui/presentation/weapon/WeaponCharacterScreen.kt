package com.example.genshinbase.ui.presentation.weapon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.genshinbase.domain.models.WeaponUI
import com.example.genshinbase.ui.navigation.Screens


@Composable
fun WeaponCharacterScreen(navHostController: NavHostController) {
    val viewModel = hiltViewModel<WeaponCharacterViewModel>()
    val state = viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.loadWeapons()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(state.value.weapons) {character ->
            WeaponItem(weaponUI = character, modifier = Modifier.fillMaxWidth())
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeaponItem(
    weaponUI: WeaponUI,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier, onClick = { }, enabled = false) {
        Row(modifier = Modifier) {
            AsyncImage(
                model = weaponUI.url,
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 3.dp)
                    .size(150.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = weaponUI.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(top = 14.dp)
                )
                Row(
                    modifier = Modifier.padding(top = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    for (i in 1..weaponUI.rarity) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color.Yellow
                        )
                    }
                }
            }


        }
    }
}