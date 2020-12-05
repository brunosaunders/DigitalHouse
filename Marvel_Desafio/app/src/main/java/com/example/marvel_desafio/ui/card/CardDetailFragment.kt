package com.example.marvel_desafio.ui.card

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        val navController = findNavController()
        binding.toolbar.setupWithNavController(navController)

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

            val price = if (comic.prices != null) "$ ${comic.prices.first().price}" else "Price is not Available"
            val pageCount = comic.pageCount?.toString()

            //Drop after T
            val date = comic.dates?.get(1)?.date?.split("T")?.first()

            tvDate.text = getFormattedDate(date)
            tvPages.text = pageCount
            tvPrice.text = price

            card.setOnClickListener {
                val action = CardDetailFragmentDirections.actionCardDetailFragmentToZoomCardFragment("$path.$extension")
                findNavController().navigate(action)
            }

        }
        return binding.root
    }

    fun getFormattedDate(string: String?): String {
        if (string == null) return "Date not available"

        val date = string.split("-")
        if (date.size > 3) return "Date not available"

        val month = when (date[1]) {
            "01" -> "January"
            "02" -> "February"
            "03" -> "March"
            "04" -> "April"
            "05" -> "May"
            "06" -> "June"
            "07" -> "July"
            "08" -> "August"
            "09" -> "September"
            "10" -> "October"
            "11" -> "November"
            else -> "December"
        }
        return "$month ${date[2]}, ${date.first()}"
    }
}