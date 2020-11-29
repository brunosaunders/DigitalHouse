package com.example.marvel_desafio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvel_desafio.R
import com.example.marvel_desafio.adapters.MarvelCardAdapter
import com.example.marvel_desafio.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.rvHome.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            adapter = MarvelCardAdapter(returnList())
            setHasFixedSize(true)
        }

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