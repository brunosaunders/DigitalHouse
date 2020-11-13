package com.example.recipes.RegisterFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recipes.R
import com.example.recipes.util.hideKeyboardOnScrolled
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        view.button_register_RegisterFragment.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
        }
        hideKeyboardOnScrolled(view.findViewById(R.id.scrollView_RegisterFragment))
        return view
    }
}