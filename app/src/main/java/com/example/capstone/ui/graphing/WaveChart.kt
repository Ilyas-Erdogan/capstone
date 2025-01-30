package com.example.capstone.ui.graphing

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.capstone.model.TestDocument
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottom
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries

@Composable
fun WaveChart(
    data: TestDocument,
    modifier: Modifier
) {
//    val chartEntryModelProducer = remember {ChartEntryModelProducer() }
//
//    LaunchedEffect(data) {
//        chartEntryModelProducer.setEntries(data.map { entryOf(it.first, it.second) })
//    }
//
//    Card(modifier = modifier) {
//        Chart(
//            chart = lineChart(),
//            chartModelProducer = chartEntryModelProducer,
//            startAxis = rememberStartAxis(),
//            bottomAxis = rememberBottomAxis()
//        )
//    }
    val modelProducer = remember { CartesianChartModelProducer() }
    LaunchedEffect(data) {
        modelProducer.runTransaction {
            lineSeries { series(x = data.xValues, y = data.yValues) }
        }
    }


    Card(modifier = modifier) {
        CartesianChartHost(
            rememberCartesianChart(
                rememberLineCartesianLayer(),
                startAxis = VerticalAxis.rememberStart(),
                bottomAxis = HorizontalAxis.rememberBottom(),
            ),
            modelProducer
        )
    }
}


//fun getRandomEntries() = List(4) { entryOf(it, Random.nextFloat() * 16) }