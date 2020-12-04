package com.example.marvel_desafio.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_desafio.R
import com.example.marvel_desafio.adapters.MarvelCardAdapter
import com.example.marvel_desafio.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this

        val characterId = 1009610
        val limit = 15

        viewModel.refreshComics(characterId, limit)
        setScrollViewListener(characterId, limit)

        val marvelAdapter = MarvelCardAdapter(MarvelCardAdapter.NavigateListener { comic ->
            val action = HomeFragmentDirections.actionHomeFragmentToCardDetailFragment(comic)
            findNavController().navigate(action)
        })

        binding.rvHome.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            adapter = marvelAdapter
        }


        //Update data on Adapter
        viewModel.listComics.observe(viewLifecycleOwner) {
            it?.let {
                marvelAdapter.data = it

                viewModel.page.value?.let {
                    viewModel.page.value = it + 1
                }
            }
        }

        return binding.root
    }

    fun setScrollViewListener(characterId: Int, limit: Int) {
        binding.rvHome.run {
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val target = recyclerView.layoutManager as LinearLayoutManager
                    val totalItemCount = target.itemCount
                    val lastVisible = target.findLastVisibleItemPosition()
                    val lastItem = lastVisible + 6 >= totalItemCount

                    if (totalItemCount > 0 && lastItem) {
                        viewModel.refreshComics(characterId, limit)
                        Log.i("HomeFragment", "Paginação ativada, posição: $lastVisible")
                        Log.i("HomeFragment", "items: $totalItemCount")
                    }
                }
            })
        }
    }
}