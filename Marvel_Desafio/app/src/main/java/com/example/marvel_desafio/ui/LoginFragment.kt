package com.example.marvel_desafio.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.FragmentLoginBinding
import com.example.marvel_desafio.util.SupportBar

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var supportBar: ActionBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        supportBar.hide()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is SupportBar) {
            supportBar = context.supportBar!!
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        supportBar.show()
    }

}