package com.example.marvel_desafio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvel_desafio.R
import com.example.marvel_desafio.adapters.MarvelCardAdapter
import com.example.marvel_desafio.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val characterId = 1009610
        val limit = 15
        val offset = 1

        viewModel.refreshComics(characterId, limit, offset)

        val marvelAdapter = MarvelCardAdapter(MarvelCardAdapter.NavigateListener { comic ->
            val action = HomeFragmentDirections.actionHomeFragmentToCardDetailFragment(comic)
            findNavController().navigate(action)
        })
        binding.rvHome.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            adapter = marvelAdapter
        }

        viewModel.listComics.observe(viewLifecycleOwner) {
            it?.let {
                marvelAdapter.data = it
            }
        }

        binding.lifecycleOwner = this

        return binding.root
    }

    fun returnList(): List<String> {
        val list = mutableListOf<String>()
        for (i in 1..100) {
            list.add(i.toString())
        }
        return list
    }
}