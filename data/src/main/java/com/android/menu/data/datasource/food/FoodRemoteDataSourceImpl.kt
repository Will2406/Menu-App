package com.android.menu.data.datasource.food


import com.android.menu.data.remote.MenuService
import com.android.menu.data.core.DataResult
import com.android.menu.data.core.fromJson
import com.android.menu.data.core.safeApiCall
import com.android.menu.data.core.toJson
import com.android.menu.data.remote.model.FoodListResponse
import com.android.menu.data.remote.model.FoodResponse
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FoodRemoteDataSourceImpl @Inject constructor(
    private val api: MenuService,
    private val firestore: FirebaseFirestore
) : FoodRemoteDataSource {


    override suspend fun getTrending(): Flow<List<FoodResponse?>> = callbackFlow {
        val listenerRegistration = firestore.collection("trending")
            .addSnapshotListener { snapshot, _ ->
                snapshot?.let {
                    val foodList = snapshot.documents.map {
                        it.data.toJson()?.let { food -> food.fromJson<FoodResponse>() }
                    }
                    trySend(foodList)
                }
            }

        awaitClose {
            listenerRegistration.remove()
        }
    }.flowOn(Dispatchers.IO)


    override suspend fun getAll(): DataResult<FoodListResponse> {
        return safeApiCall { api.getAllFood() }
    }
}