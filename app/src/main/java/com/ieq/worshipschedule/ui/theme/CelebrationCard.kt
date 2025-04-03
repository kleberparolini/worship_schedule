package com.ieq.worshipschedule.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ieq.worshipschedule.CelebrationData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CelebrationDayCardUI(celebrationData: CelebrationData, context: Context) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        onClick = {
            Toast.makeText(context, "botao clicado", Toast.LENGTH_LONG).show()
        }
    ) {
        Column(
            Modifier
                .background(Color.LightGray)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "Culto de ${celebrationData.celebrationName}",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "Ministro: ${celebrationData.ministerName}",
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "Dia: ${celebrationData.date}",
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
    }
}