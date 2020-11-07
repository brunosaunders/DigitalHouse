package com.example.wallet.UI.DetailGastos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallet.R
import com.example.wallet.domain.Gasto
import kotlinx.android.synthetic.main.activity_gastos_detail.*

class GastosDetailActivity : AppCompatActivity() {
    val listGastos = getList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastos_detail)

        detail_gastos_recyclerView.adapter = GastosDetailAdapter(this, listGastos)
        detail_gastos_recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        detail_gastos_recyclerView.setHasFixedSize(true)

    }

    fun getList(): List<Gasto> {
        val gasto1 = Gasto("1 pizza calabresa e 1 pizza portuguesa", "Comida", "16/07/2020", "35.20")
        val gasto2 = Gasto("Uber para o Órbita Bar", "Deslocamento", "29/10/2020", "26.03")
        val gasto3 = Gasto("Notebook i7 com 16GB de RAM", "Magazine Luiza", "20/10/2017", "4320.76")

        return listOf(gasto1, gasto2, gasto3, gasto1, gasto3, gasto2, gasto2, gasto3, gasto2, gasto1, gasto3, gasto2)
    }
}