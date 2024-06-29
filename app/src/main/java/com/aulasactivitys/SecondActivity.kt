package com.aulasactivitys

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aulasactivitys.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener { finish() }

        val bundle = intent.extras //esse objeto tem todos os parametros passados
        if (bundle != null) {
            //val filme = bundle.getString("filme")
            //val classificacao = bundle.getInt("classificacao")
            //val avaliacoes = bundle.getDouble("avaliacoes")

            //val resultado = "filme: $filme - class. $classificacao - aval. $avaliacoes"

            val filme = if (Build.VERSION.SDK_INT >= 33) {
                //bundle.getSerializable("filme", Filme::class.java)
                bundle.getParcelable("filme", Filme::class.java)
            } else {
                //bundle.getSerializable("filme") as Filme
                bundle.getParcelable("filme")
            }

            binding.filmName.text = "${filme?.nome} - ${filme?.distribuidor}"
        }
    }
}