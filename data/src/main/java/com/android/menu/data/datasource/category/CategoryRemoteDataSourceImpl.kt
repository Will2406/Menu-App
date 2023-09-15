package com.android.menu.data.datasource.category


import com.android.menu.data.core.fromJson
import com.android.menu.data.core.safeApiCall
import com.android.menu.data.core.toJson
import com.android.menu.data.remote.model.CategoryResponse
import com.android.menu.data.remote.model.FoodResponse
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : CategoryRemoteDataSource {

    override suspend fun getAll(): Flow<List<CategoryResponse?>> = callbackFlow {
        val listenerRegistration = firestore.collection("category")
            .addSnapshotListener { snapshot, _ ->
                snapshot?.let {
                    val categoryList = snapshot.documents.map {
                        it.data.toJson()?.let { food -> food.fromJson<CategoryResponse>() }
                    }
                    trySend(categoryList)
                }
            }

        awaitClose {
            listenerRegistration.remove()
        }
    }.flowOn(Dispatchers.IO)


}