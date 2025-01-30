package com.example.capstone.ui.Stats

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.capstone.CapstoneApplication
import com.example.capstone.model.service.DocumentService
import com.example.capstone.ui.CapstoneViewModel

class StatsViewModel(
    documentService: DocumentService
) : CapstoneViewModel() {
    val testDocument = documentService.testData

    val uiState = documentService.testData

//    private val _uiState: MutableStateFlow<TestDocument> = MutableStateFlow(TestDocument())
//    val uiState: StateFlow<TestDocument> = _uiState.asStateFlow()

    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            documentService.testData.collectLatest { it ->
//            }
//        }
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