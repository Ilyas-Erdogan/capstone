package com.example.capstone.model.service

import com.example.capstone.model.TestDocument
import kotlinx.coroutines.flow.Flow

interface DocumentService {
    val testData: Flow<TestDocument>
}