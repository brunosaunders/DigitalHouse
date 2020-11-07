package com.example.wallet.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.wallet.domain.Gasto

@Entity
data class DatabaseGasto constructor(
    @PrimaryKey
    val descricao: String,
    val categoria: String,
    val data: String,
    val valor: Double
)

fun List<DatabaseGasto>.asDomainModel(): List<Gasto> {
    return map {
        Gasto(it.descricao, it.categoria, it.data, it.valor.toString())
    }
}