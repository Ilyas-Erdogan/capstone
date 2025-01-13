package com.example.capstone.ui.Stats

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.capstone.CapstoneApplication
import com.example.capstone.model.service.DocumentService
import com.example.capstone.ui.CapstoneViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class StatsViewModel(
    documentService: DocumentService
) : CapstoneViewModel() {
    val testDocument = documentService.testData

    private val _uiState: MutableStateFlow<List<Pair<Float, Float>>> = MutableStateFlow(listOf())
    val uiState: StateFlow<List<Pair<Float, Float>>> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            documentService.testData.collectLatest { it ->
                val newList : MutableList<Pair<Float, Float>> = mutableListOf()
                for (i in 0..<it.xValues.size) {
                    if (i < it.yValues.size) {
                        newList.add(Pair(it.xValues[i], it.yValues[i]))
                    }
                }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CapstoneApplication)
                val documentService = application.container.documentService
                StatsViewModel(documentService = documentService)
            }
        }
    }
}