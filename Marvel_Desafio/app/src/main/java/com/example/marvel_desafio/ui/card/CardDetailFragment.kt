package com.example.marvel_desafio.ui.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.FragmentCardDetailBinding

class CardDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentCardDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_card_detail, container, false)

        val navController = activity?.findNavController(R.id.nav_host_fragment_main)
        binding.toolbar.setupWithNavController(navController!!)

        
        return binding.root
    }
}