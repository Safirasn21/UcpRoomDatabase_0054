package com.example.ucp2.data.repository

import com.example.ucp2.data.dao.BarangDao
import com.example.ucp2.data.entity.Barang
import kotlinx.coroutines.flow.Flow

class LocalRepositoryB (
    private val barangDao: BarangDao): RepositoryB {
    override suspend fun insertBarang(barang: Barang) {
        barangDao.insertBarang(barang)
    }
    override fun getAllBarang(): Flow<List<Barang>> {
        return barangDao.getAllBarang()
    }
    override fun getBarang(id_B: String): Flow<Barang> {
        return barangDao.getBarang(id_B)
    }

}