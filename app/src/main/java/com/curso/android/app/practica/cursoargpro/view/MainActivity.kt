package com.curso.android.app.practica.cursoargpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.practica.cursoargpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparacion.observe(this) {
            binding.resultado.text = it.msj
        }

        binding.btnComparacion.setOnClickListener {
            val cadena1 = binding.cadena1.text.toString()
            val cadena2 = binding.cadena2.text.toString()
            mainViewModel.comparar(cadena1, cadena2)
        }
    }
}