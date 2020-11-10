package com.example.recipes.util

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.ScrollView
import kotlin.math.absoluteValue

fun hideKeyboardOnScrolled(scrollView: ScrollView) {
    scrollView.setOnScrollChangeListener { view, _, scrollY, _, oldScrollY ->
        when {
            (scrollY - oldScrollY).absoluteValue > 15 -> {
                val imm: InputMethodManager = scrollView.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}