package com.example.wallet

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gastos_detail.view.*

class GastosDetailFragment : Fragment() {
    private var msg = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gastos_detail, container, false)

        if (msg != "") {
            view.gastos_detail_textview.text = msg
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getString("key")?.let {
            msg = it
        }
    }

    companion object {
        fun newInstance(msg: String) = GastosDetailFragment().apply {
            arguments = Bundle().apply {
                putString("key", msg)
            }
        }
    }
}