package com.ieq.worshipschedule.ui.theme.screen.celebration_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
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
        floatingActionButton = {
            FloatingActionButton(onClick = onAddCelebrationEvent
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
                start = 20.dp,
                end = 20.dp,
                top = 20.dp + padding.calculateTopPadding(),
                bottom = 20.dp + padding.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            item {
                Text(
                    text = "Bem vindo, louvorista!",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            items(celebrationList) { celebration ->
                ListItem(
                    headlineText = {
                        Text(text = celebration.name)
                    },
                    supportingText = {
                        Text(
                            text = "${celebration.ministerName} - ${celebration.date}",
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    modifier = Modifier.clickable(onClick = {
                        onCelebrationClick(celebration)
                    })
                )
            }
        }
    }
}