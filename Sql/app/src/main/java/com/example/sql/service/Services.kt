package com.example.sql.service

import androidx.lifecycle.LiveData
import com.example.sql.Gasto
import com.example.sql.database.GastoDao

interface Repository {

    //insert
    suspend fun addGastoTask(gasto: Gasto): List<Gasto>

    //selects
    suspend fun getAllGastosTask(): List<Gasto>

    //updates

    //deletes
}

class RepositoryImplement(val gastoDao: GastoDao): Repository {
    override suspend fun addGastoTask(gasto: Gasto) {
        gastoDao.addGasto(gasto)
    }

    override suspend fun getAllGastosTask(): List<Gasto> {
        return gastoDao.getAllGastos()
    }
}