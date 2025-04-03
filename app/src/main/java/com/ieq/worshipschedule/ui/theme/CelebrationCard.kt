package com.ieq.worshipschedule.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ieq.worshipschedule.CelebrationData

@Composable
fun CelebrationDayCardUI(celebrationData: CelebrationData) {
    Card(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 10.dp)
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)) {

        Column(Modifier.background(Color.Gray)) {
            Text(
                text = "Culto de ${celebrationData.celebrationName}", color = Color.Black, fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ministro: ${celebrationData.ministerName}", color = Color.Black, fontWeight = FontWeight.Normal
            )
            Text(
                text = "Dia: ${celebrationData.date}", color = Color.Black, fontWeight = FontWeight.Normal
            )
        }
    }
}