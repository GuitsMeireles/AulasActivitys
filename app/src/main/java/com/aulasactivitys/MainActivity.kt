package com.aulasactivitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aulasactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "onCreate")
        setContentView(binding.root)

        setupListeners()
    }

    override fun onStart() {
        super.onStart()
        //Carregar dados
        Log.i("ciclo_vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo_vida", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo_vida", "onDestroy")
    }

    private fun setupListeners() {
        binding.btnNext.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)

            //passar valores para a proxima tela
            //i.putExtra("filme", "O poderoso chefao")
            //i.putExtra("classificacao", 5)
            //i.putExtra("avaliacoes", 9.2)

            val filme = Filme(
                "O poderoso chefao",
                "teste",
                9.2,
                "Guilherme",
                "Netflix"
                )

            i.putExtra("filme", filme)

            startActivity(i)
        }
    }
}