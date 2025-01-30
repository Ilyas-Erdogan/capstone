package com.example.capstone.ui.Stats

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstone.model.TestDocument
import com.example.capstone.ui.graphing.WaveChart
import com.example.capstone.ui.theme.AppTypography

@Composable
fun StatsScreen(
    modifier: Modifier = Modifier,
    viewModel: StatsViewModel = viewModel(factory = StatsViewModel.Factory)
) {

    val testDoc = viewModel.uiState.collectAsStateWithLifecycle(
        initialValue = TestDocument(
            listOf(1f),
            listOf(1f)
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Good Afternoon, Ilyas",
            style = AppTypography.titleLarge,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Brain Activity",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        WaveChart(
            data = testDoc.value, modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = "Heart Rate",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        WaveChart(
            data = testDoc.value, modifier = Modifier
                .fillMaxWidth()

        )

        val brush = Brush.horizontalGradient(
            listOf(
                Color(0xFF00FF26),
                Color(0xFFD9FF00),
                Color(0xFFEC8000),
                Color(0xFFFF0000)
            )
        )

        Text(
            text = "Permanence",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "0", style = AppTypography.bodyMedium)
                Text(text = "100", style = AppTypography.bodyMedium)
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(brush)
                        .border(4.dp, Color.Black, RoundedCornerShape(16.dp))
                ) {}
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth((testDoc.value.yValues.average() / 100f).toFloat())
                ) {
                    Column(
                        modifier = Modifier
                            .width(8.dp)
                            .height(32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.Gray)

                    ) {}
                }
            }
        }

    }
}