package com.example.webservices.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Resultado(@SerializedName("produtos") @Expose var produtos: List<Produto>) {
}