package com.example.ucp2.data.repository

import com.example.ucp2.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

interface RepositoryS {
    suspend fun insertSuplier(suplier: Suplier)
    fun  getAllSuplier(): Flow<List<Suplier>>
}