package com.curso.android.app.practica.cursoargpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.curso.android.app.practica.cursoargpro.databinding.ActivityMainBinding
import com.curso.android.app.practica.cursoargpro.model.Comparacion

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
            val primerCadena = binding.cadena1
            val segundaCadena = binding.cadena2
            mainViewModel.comparar(primerCadena, segundaCadena) }
    }
}