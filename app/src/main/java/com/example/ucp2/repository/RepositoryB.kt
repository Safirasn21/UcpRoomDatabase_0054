package com.example.ucp2.repository

import com.example.ucp2.data.entity.Barang
import kotlinx.coroutines.flow.Flow

interface RepositoryB {
    suspend fun insertBarang(barang: Barang)
    fun getAllBarang(): Flow<List<Barang>>
    fun getBarang(id_B: String): Flow<Barang>
    suspend fun deleteBarang(barang: Barang)
    suspend fun updateBarang(barang: Barang)
}