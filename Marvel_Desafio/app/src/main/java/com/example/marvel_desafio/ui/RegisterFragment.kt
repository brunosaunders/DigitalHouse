package com.example.marvel_desafio.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.FragmentRegisterBinding
import com.example.marvel_desafio.util.SupportBar


class RegisterFragment : Fragment() {
    private lateinit var supportBar: ActionBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        binding.btnSave.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            supportBar.hide()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SupportBar) supportBar = context.supportBar!!
    }
}