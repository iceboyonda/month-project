package com.example.genshinbase.ui.presentation.detailCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage


@Composable
fun DetailCharacterScreen(navHostController: NavHostController, characterId: Long) {
    val viewModel = hiltViewModel<DetailCharacterViewModel>()
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.loadCharacter(characterId)
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.weight(1f)) {
            AsyncImage(
                model = state.characterUI.url,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        MaterialTheme.colorScheme.surface
                    )
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            navHostController.popBackStack()
                        },
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        MaterialTheme.colorScheme.inversePrimary.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(
                        RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = state.characterUI.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier) {
                            Text(
                                text = "Редкость",
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                modifier = Modifier.padding(top = 7.dp),
                                horizontalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                for (i in 1..state.characterUI.rarity) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = null,
                                        tint = Color.Yellow
                                    )
                                }
                            }
                        }

                        Column(modifier = Modifier) {
                            Text(
                                text = "Элемент",
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = state.characterUI.element.name,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(top = 7.dp)
                            )
                        }
                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier) {
                            Text(
                                text = "Оружие",
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = state.characterUI.weapon.name,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(top = 7.dp)
                            )
                        }

                        Column(modifier = Modifier) {
                            Text(
                                text = "Регион",
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = state.characterUI.region.name,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(top = 7.dp)
                            )
                        }
                    }
                }

            }
        }

        Text(
            text = "Описание",
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 10.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 5.dp)
        )

        Text(
            text = state.characterUI.description,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 5.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
        )

    }
}