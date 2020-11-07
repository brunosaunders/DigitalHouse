package com.example.wallet.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.wallet.domain.Gasto

@Dao
interface GastoDao {
    @Query("Select * from databasegasto")
    fun getGastos(): LiveData<List<Gasto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gasto: Gasto)
}

@Database(entities = [Gasto::class], version = 1)
abstract class GastosDatabase : RoomDatabase() {
    abstract val dao: GastoDao
}

private lateinit var INSTANCE: GastosDatabase

fun getGastosDatabase(context: Context): GastosDatabase {
    synchronized(GastosDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                GastosDatabase::class.java,
                "gastos"
            ).build()
        }
    }
    return INSTANCE
}