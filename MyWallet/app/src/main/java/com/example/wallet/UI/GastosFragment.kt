package com.example.wallet.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.wallet.R
import com.example.wallet.databinding.FragmentGastosBinding
import com.example.wallet.domain.Gasto

class GastosFragment : Fragment() {
    private lateinit var cadastro: Gasto
    private lateinit var binding: FragmentGastosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gastos, container, false)



        return binding.root
    }
}