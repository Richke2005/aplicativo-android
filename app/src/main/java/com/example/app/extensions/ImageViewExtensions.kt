package com.example.app.extensions

import android.widget.ImageView
import coil3.load
import coil3.request.error
import coil3.request.placeholder
import com.example.app.R

fun ImageView.tentaCarregarImagem(url: String? = null){
    load(url){
        error(R.drawable.erro)
        placeholder(R.drawable.ic_action_refresh)
    }
}