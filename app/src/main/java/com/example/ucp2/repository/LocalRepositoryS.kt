package com.example.ucp2.repository

import com.example.ucp2.data.dao.SuplierDao
import com.example.ucp2.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

class LocalRepositoryS (
    private val suplierDao: SuplierDao): RepositoryS {

    override suspend fun insertSuplier(suplier: Suplier) {
        suplierDao.insertSuplier(suplier)
    }
    override fun getAllSuplier(): Flow<List<Suplier>> {
        return suplierDao.getAllSuplier()
    } }
