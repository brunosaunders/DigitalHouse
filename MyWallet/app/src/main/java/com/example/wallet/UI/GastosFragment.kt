package com.example.wallet.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wallet.R
import com.example.wallet.domain.Gasto
import kotlinx.android.synthetic.main.fragment_gastos.view.*

class GastosFragment : Fragment() {
    private lateinit var cadastro: Gasto

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gastos, container, false)

        view.cadastrar_button_gastos.setOnClickListener {
            val descricao = view.descricao_edit_text.text.toString()
            val categoria = view.categoria_edit_text.text.toString()
            val data = view.data_hora_edit_text.text.toString()
            val valor = view.valor_edit_text.text.toString().toDouble()
            cadastro = Gasto(descricao, categoria, data, valor)

            Toast.makeText(context, cadastro.descricao, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}