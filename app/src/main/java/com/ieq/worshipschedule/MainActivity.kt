package com.ieq.worshipschedule

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ieq.worshipschedule.ui.theme.CelebrationDayCardUI
import com.ieq.worshipschedule.ui.theme.WorshipScheduleTheme

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
                    ConfigListView(LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun ConfigListView(context: Context, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "Bem vindo, louvorista!",
            modifier = modifier
                .padding(top = 10.dp)
                .align(CenterHorizontally),
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
        )
        Row(modifier = modifier) {
            val celebrationList = listOf(
                CelebrationData("Primicias", "Cris", "03/04/2025"),
                CelebrationData("Santa Ceia", "Cris", "03/04/2025"),
                CelebrationData("Missões", "Cris", "03/04/2025"),
                CelebrationData("Familia", "Cris", "03/04/2025"),
                CelebrationData("Primicias", "Cris", "03/04/2025"),
                CelebrationData("Santa Ceia", "Cris", "03/04/2025"),
                CelebrationData("Missões", "Cris", "03/04/2025"),
                CelebrationData("Familia", "Cris", "03/04/2025"),
                CelebrationData("Primicias", "Cris", "03/04/2025"),
                CelebrationData("Santa Ceia", "Cris", "03/04/2025"),
                CelebrationData("Missões", "Cris", "03/04/2025"),
                CelebrationData("Familia", "Cris", "03/04/2025")
            )

            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                items(celebrationList) { celebration ->
                    CelebrationDayCardUI(celebrationData = celebration, context)
                }
            }
        }
    }
    Row(
        modifier = modifier.padding(all = 10.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = modifier.size(60.dp),
            enabled = true
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_circle_24),
                contentDescription = null,
                modifier = modifier.size(80.dp)
            )
        }
    }

}