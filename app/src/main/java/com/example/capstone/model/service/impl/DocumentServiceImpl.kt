package com.example.capstone.model.service.impl

import android.util.Log
import com.example.capstone.model.TestDocument
import com.example.capstone.model.service.DocumentService
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class DocumentServiceImpl : DocumentService {
    override val testData: Flow<TestDocument>
        get() = callbackFlow<TestDocument> {
            Firebase.firestore.collection(TEST_DATA).document("yjP3kHm2R4iRn1SPjHED")
                .addSnapshotListener { value, error ->
                    if (error != null) {
                        Log.e(TAG, "Failed to get test data document")
                    }

                    if (value != null) {
                        Log.i(TAG, "${value.data?.get("xValues")}")
                        value.toObject(TestDocument::class.java)?.let { trySend(it) }
                    }
                }
            awaitClose {

            }
        }

    companion object {
        const val TAG = "DocumentService"
        const val TEST_DATA = "TEST_DATA"
    }
}