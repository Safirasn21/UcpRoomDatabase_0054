package com.example.ucp2.data.dao

import androidx.room.Dao
import androidx.room.DatabaseView
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp2.data.entity.Suplier
import kotlinx.coroutines.flow.Flow


@Dao
interface SuplierDao {
    @Insert
    suspend fun insertSuplier(
        suplier: Suplier
    )
    @Query("SELECT*FROM suplier ORDER BY supname ASC")
    fun  getAllSuplier(): Flow<List<Suplier>>
}