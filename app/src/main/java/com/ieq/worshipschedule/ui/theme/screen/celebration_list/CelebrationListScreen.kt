package com.ieq.worshipschedule.ui.theme.screen.celebration_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ieq.worshipschedule.domain.model.Celebration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CelebrationListScreen(
    celebrationList: List<Celebration>,
    onCelebrationClick: (celebration: Celebration) -> Unit,
    onAddCelebrationEvent: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Bem vindo, louvorista!",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                modifier = Modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddCelebrationEvent
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "adicionar"
                )
            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 5.dp,
                end = 5.dp,
                top = 15.dp + padding.calculateTopPadding(),
                bottom = 15.dp + padding.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items(celebrationList) { celebration ->
                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    onClick = { onCelebrationClick.invoke(celebration) }
                ) {
                    Column(
                        Modifier
                            .background(Color.LightGray)
                            .fillMaxSize()
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Culto de ${celebration.name}",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Ministro: ${celebration.ministerName}",
                            color = Color.Black,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Dia: ${celebration.date}",
                            color = Color.Black,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}