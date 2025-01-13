package com.example.capstone.ui.Stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstone.model.TestDocument
import com.example.capstone.ui.graphing.WaveChart

@Composable
fun StatsScreen(
    modifier: Modifier = Modifier,
    viewModel: StatsViewModel = viewModel(factory = StatsViewModel.Factory)
) {

    val testDoc = viewModel.uiState.collectAsStateWithLifecycle(initialValue = listOf())

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(text = "Values Test")
//        LazyRow {
//            items(testDoc.value.xValues) { xValue ->
//                Text(text = "$xValue", modifier = Modifier.padding(4.dp))
//            }
//        }
//        LazyRow {
//            items(testDoc.value.yValues) { yValue ->
//                Text(text = "$yValue", modifier = Modifier.padding(4.dp))
//            }
//        }

        WaveChart(data = testDoc.value, modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp))
    }
}