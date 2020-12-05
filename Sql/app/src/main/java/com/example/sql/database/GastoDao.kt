package com.example.sql.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sql.Gasto

@Dao
interface GastoDao {

    //insert
    @Insert
    suspend fun addGasto(gasto: Gasto): List<Gasto>

    //select
    @Query("SELECT * FROM gastos")
    suspend fun getAllGastos(): List<Gasto>

    //update


    //delete
}