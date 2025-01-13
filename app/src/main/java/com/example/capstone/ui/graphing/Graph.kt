package com.example.capstone.ui.graphing

import android.util.Log
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryOf
import kotlin.random.Random

@Composable
fun WaveChart(
    data: List<Pair<Float, Float>>,
    modifier: Modifier
) {
    val chartEntryModelProducer = remember {ChartEntryModelProducer() }

    LaunchedEffect(data) {
        chartEntryModelProducer.setEntries(data.map { entryOf(it.first, it.second) })
    }

    Card(modifier = modifier) {
        Chart(
            chart = lineChart(),
            chartModelProducer = chartEntryModelProducer,
            startAxis = rememberStartAxis(),
            bottomAxis = rememberBottomAxis()
        )
    }

}


fun getRandomEntries() = List(4) { entryOf(it, Random.nextFloat() * 16) }