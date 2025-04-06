package com.ieq.worshipschedule.ui.theme.screen.celebration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CelebrationScreen(
    state: CelebrationState,
    onEvent: (CelebrationEvent) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { /*TODO*/ },
                navigationIcon = {
                    IconButton(
                        onClick = { onEvent(CelebrationEvent.NavigateBack) }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "voltar"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { onEvent(CelebrationEvent.DeleteNote) },
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = "excluir"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 5.dp, vertical = 5.dp)
        ) {
            OutlinedTextField(
                value = state.name,
                onValueChange = {
                    onEvent(CelebrationEvent.NameChange(it))
                },
                label = {
                    Text(text = "Culto")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = state.ministerName,
                onValueChange = {
                    onEvent(CelebrationEvent.MinisterNameChange(it))
                },
                label = {
                    Text(text = "Ministro")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = state.date,
                onValueChange = {
                    onEvent(CelebrationEvent.DateChange(it))
                },
                label = {
                    Text(text = "Data")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { onEvent(CelebrationEvent.Save) },
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(text = "salvar")
                }
            }
        }
    }
}