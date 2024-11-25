package com.example.app.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.app.databinding.FormularioImagemBinding
import com.example.app.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostra(
        urlPadrao: String? = null,
        quandoImagemcarregada: (imagem: String) -> Unit
    ) {
        val binding = FormularioImagemBinding
            .inflate(LayoutInflater.from(context))

        urlPadrao?.let {
            binding.formularioImagemImageview.tentaCarregarImagem(it)
            binding.formularioImagemUrl.setText(it)
        }

        binding.fomularioImagemBotaoCarregar.setOnClickListener {
            val url = binding.formularioImagemUrl.text.toString()
            binding.formularioImagemImageview.tentaCarregarImagem(url)
        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("OK") { _, _ ->
                val url = binding.formularioImagemUrl.text.toString()
                quandoImagemcarregada(url)
            }
            .setNegativeButton("Cancelar") { _, _ -> }
            .show()
    }
}