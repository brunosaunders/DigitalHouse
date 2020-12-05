package com.example.sql

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.sql.SQLException

class DataBaseHandler(
    context: Context,
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "app_database"
        private val DATABASE_VERSION = 1

        //Constantes tabela gasto
        private val TABLE_GASTO = "gastos"
        private val KEY_ID = "id"
        private val KEY_NOME = "nome"
        private val KEY_VALOR = "valor"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_GASTO = "CREATE TABLE $TABLE_GASTO(\n" +
                "        $KEY_ID INTEGER PRIMARY KEY,\n" +
                "        $KEY_NOME TEXT,\n" +
                "        $KEY_VALOR REAL\n" +
                "        ) ;"
        db?.execSQL(CREATE_TABLE_GASTO)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_GASTO")
    }

    //INSERT INTO gastos(id, nome, valor) VALUES(1, "comida", 10.0)

    //INSERT
    fun addGastoDatabase(gasto: Gasto): Long {
        val db = this.writableDatabase

        val content = ContentValues()
        content.put(KEY_NOME, gasto.nome)
        content.put(KEY_VALOR, gasto.valor)
        val result = db.insert(TABLE_GASTO, null, content)
        db.close()
        return result
    }

    //Select
    fun getAllGastos(): List<Gasto> {
        var listGastos = ArrayList<Gasto>()
        val query = "SELECT * FROM $TABLE_GASTO"
        val db = this.writableDatabase

        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(query, null)
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                    var nome = cursor.getString(cursor.getColumnIndex(KEY_NOME))
                    var valor = cursor.getDouble(cursor.getColumnIndex(KEY_VALOR))

                    listGastos.add(Gasto(id, nome, valor))
                } while (cursor.moveToNext())
            }
        } catch (e: SQLException) {
            Log.e("DatabaseHandler", e.toString())
        }
        return listGastos
    }
}