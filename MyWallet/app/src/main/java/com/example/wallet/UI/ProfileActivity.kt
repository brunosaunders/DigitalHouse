package com.example.wallet.UI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wallet.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    var exportar_dados = true
    var sincronizacao = false
    var historico = true
    var notificacoes = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        exportar_dados_checkbox.setOnClickListener {
            exportar_dados = when (exportar_dados) {
                false -> {
                    exportar_dados_checkbox.setBackgroundResource(R.drawable.round_purple_checkbox)
                    exportar_dados_text.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
                    true
                }
                else -> {
                    exportar_dados_checkbox.setBackgroundResource(R.drawable.round_uncheckedbox)
                    exportar_dados_text.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                    false
                }
            }
        }
        sincronizacao_checkbox.setOnClickListener {
            sincronizacao = when (sincronizacao) {
                false -> {
                    sincronizacao_checkbox.setBackgroundResource(R.drawable.round_purple_checkbox)
                    sincronizacao_text.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
                    true
                }
                else -> {
                    sincronizacao_checkbox.setBackgroundResource(R.drawable.round_uncheckedbox)
                    sincronizacao_text.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                    false
                }
            }
        }
        historico_checkbox.setOnClickListener {
            historico = when (historico) {
                false -> {
                    historico_checkbox.setBackgroundResource(R.drawable.round_purple_checkbox)
                    historico_text.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
                    true
                }
                else -> {
                    historico_checkbox.setBackgroundResource(R.drawable.round_uncheckedbox)
                    historico_text.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                    false
                }
            }
        }
        notificacoes_checkbox.setOnClickListener {
            notificacoes = when (notificacoes) {
                false -> {
                    notificacoes_checkbox.setBackgroundResource(R.drawable.round_purple_checkbox)
                    notificacoes_text.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
                    true
                }
                else -> {
                    notificacoes_checkbox.setBackgroundResource(R.drawable.round_uncheckedbox)
                    notificacoes_text.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                    false
                }
            }
        }
    }

}