package com.ieq.worshipschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ieq.worshipschedule.ui.theme.CelebrationDayCardUI
import com.ieq.worshipschedule.ui.theme.WorshipScheduleTheme
import java.time.Instant
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorshipScheduleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   ConfigListView()
                }
            }
        }
    }
}

@Composable
fun ConfigListView(modifier: Modifier = Modifier) {
Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        text = "Olá louvorista!",
        modifier = modifier
    )

    val celebrationList = listOf(
        CelebrationData("Primicias", "Cris", Date.from(Instant.now())),
        CelebrationData("Santa Ceia", "Cris", Date.from(Instant.now())),
        CelebrationData("Missões", "Cris", Date.from(Instant.now())),
        CelebrationData("Familia", "Cris", Date.from(Instant.now())),
        CelebrationData("Louvor", "Cris", Date.from(Instant.now())),
        CelebrationData("Primicias", "Cris", Date.from(Instant.now())),
        CelebrationData("Santa Ceia", "Cris", Date.from(Instant.now())),
        CelebrationData("Missões", "Cris", Date.from(Instant.now())),
        CelebrationData("Familia", "Cris", Date.from(Instant.now())),
        CelebrationData("Louvor", "Cris", Date.from(Instant.now())),
        CelebrationData("Primicias", "Cris", Date.from(Instant.now())),
        CelebrationData("Santa Ceia", "Cris", Date.from(Instant.now())),
        CelebrationData("Missões", "Cris", Date.from(Instant.now())),
        CelebrationData("Familia", "Cris", Date.from(Instant.now())),
        CelebrationData("Louvor", "Cris", Date.from(Instant.now())),
        CelebrationData("Primicias", "Cris", Date.from(Instant.now())),
        CelebrationData("Santa Ceia", "Cris", Date.from(Instant.now())),
        CelebrationData("Missões", "Cris", Date.from(Instant.now())),
        CelebrationData("Familia", "Cris", Date.from(Instant.now())),
        CelebrationData("Louvor", "Cris", Date.from(Instant.now()))
    )

    LazyColumn(
        modifier = Modifier.
        padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
       items(celebrationList) { celebration ->
           CelebrationDayCardUI(celebrationData = celebration)
        }
    }
}

}