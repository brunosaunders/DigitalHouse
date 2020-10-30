package com.example.wallet.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wallet.Interface.ActivityContract
import com.example.wallet.R
import com.example.wallet.domain.State
import com.example.wallet.domain.Usuario
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    var activeState = State.ENTRADAS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_fragment, EntradasFragment())
            .commit()

        val usuario = intent.getSerializableExtra("key") as Usuario
        Toast.makeText(this, usuario.nome, Toast.LENGTH_LONG).show()

        changeToPurple()

        home_layout.setOnClickListener {
            changeState(State.HOME)
            navigateToFragment(HomeFragment())
        }
        entradas_layout.setOnClickListener {
            changeState(State.ENTRADAS)
            navigateToFragment(EntradasFragment())
        }
        gastos_layout.setOnClickListener {
            changeState(State.GASTOS)
            navigateToFragment(GastosFragment())
        }
    }

    @SuppressLint("ResourceAsColor")
    fun changeToPurple() {
        when (activeState) {
            State.ENTRADAS -> {
                entradas_line.setBackgroundColor(R.color.colorPurple)
                entradas_textview.setTextColor(R.color.colorPurple)
                entradas_image.setColorFilter(R.color.colorPurple)
            }
            State.HOME -> {
                home_line.setBackgroundColor(R.color.colorPurple)
                home_textview.setTextColor(R.color.colorPurple)
                home_image.setColorFilter(R.color.colorPurple)
            }
            State.GASTOS -> {
                gastos_line.setBackgroundColor(R.color.colorPurple)
                gastos_textview.setTextColor(R.color.colorPurple)
                gastos_image.setColorFilter(R.color.colorPurple)
            }
        }
    }

    fun changeState(state: State) {
        changeToWhite()
        activeState = state
        changeToPurple()
    }

    fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_fragment, fragment)
            .commit()
    }

    fun changeToWhite() {
        when (activeState) {
            State.ENTRADAS -> {
                entradas_line.setBackgroundColor(Color.WHITE)
                entradas_textview.setTextColor(Color.WHITE)
                entradas_image.setColorFilter(Color.WHITE)
            }
            State.HOME -> {
                home_line.setBackgroundColor(Color.WHITE)
                home_textview.setTextColor(Color.WHITE)
                home_image.setColorFilter(Color.WHITE)
            }
            State.GASTOS -> {
                gastos_line.setBackgroundColor(Color.WHITE)
                gastos_textview.setTextColor(Color.WHITE)
                gastos_image.setColorFilter(Color.WHITE)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                val intent = Intent(this, ProfileeActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }
}