package com.example.marvel_desafio.ui.zoom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.FragmentZoomCardBinding

class ZoomCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentZoomCardBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_zoom_card, container, false)

        val path = arguments?.getString("path")
        val navController = findNavController()
        binding.toolbar.setNavigationOnClickListener {
            navController.navigateUp()
        }

        Glide.with(binding.ivZoomedCard.context).load(path).into(binding.ivZoomedCard)
        return binding.root
    }
}