package com.example.marvel_desafio.ui.card

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.FragmentCardDetailBinding
import com.example.marvel_desafio.domain.Comic

class CardDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentCardDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_card_detail, container, false)

        val navController = activity?.findNavController(R.id.nav_host_fragment_main)
        binding.toolbar.setupWithNavController(navController!!)

        val comic = arguments?.getSerializable("comic") as Comic
        Log.i("CardDetailFragment", comic.toString())

        binding.apply {
            val pathBigger = comic.images?.firstOrNull()?.path
            val extensionBigger = comic.images?.firstOrNull()?.extension

            Glide.with(ivBiggerImage.context).load("$pathBigger.$extensionBigger").into(ivBiggerImage)

            val path = comic.thumbnail?.path
            val extension = comic.thumbnail?.extension

            Glide.with(ivSmallerImage.context).load("$path.$extension").into(ivSmallerImage)

            tvTitle.text = comic.title

            comic.description?.let {
                tvDescription.text = Html.fromHtml(it).toString()
            }

        }
        return binding.root
    }
}