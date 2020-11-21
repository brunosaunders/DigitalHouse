package com.example.aulacoroutines18112020

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp)) {
                val string = remember { mutableStateOf("SplashScreen") }
                val modifier = Modifier.align(Alignment.CenterHorizontally)

                Spacer(Modifier.weight(1.0f))

                Text("Splash Screen", modifier.align(Alignment.CenterHorizontally))

                Spacer(Modifier.weight(1.0f))
                
            }
        }

        scope.launch {
            delay(3000)
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}