package com.example.wallet.UI.DetailGastos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.domain.Gasto
import kotlinx.android.synthetic.main.list_gastos.view.*

class GastosDetailAdapter(context: Context, val data: List<Gasto>) : RecyclerView.Adapter<GastosDetailAdapter.GastosDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastosDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_gastos, parent, false)

        return GastosDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: GastosDetailViewHolder, position: Int) {
        val item = data[position]

        holder.descricaoText.text = item.descricao
        holder.categoriaText.text = item.categoria
        holder.valorText.text = "R$ " + item.valor.toString()
        holder.dataText.text = item.data
    }

    override fun getItemCount(): Int {
        return data.size
    }
    class GastosDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val descricaoText = view.descricao_gastos
        val categoriaText = view.categoria_gastos
        val valorText = view.valor_gastos
        val dataText = view.data_gastos
    }
}