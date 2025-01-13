package com.example.capstone.data

import com.example.capstone.model.service.DocumentService
import com.example.capstone.model.service.impl.DocumentServiceImpl

interface AppContainer {
    val documentService: DocumentService
}

class DefaultAppContainer() : AppContainer {
    override val documentService: DocumentService = DocumentServiceImpl()
}