package com.example.wallet.UI

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallet.R
import com.example.wallet.UI.DetailGastos.GastosDetailActivity
import kotlinx.android.synthetic.main.fragment_gastos_detail.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.detail_gastos_home.setOnClickListener {
            val intent = Intent(context, GastosDetailActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}