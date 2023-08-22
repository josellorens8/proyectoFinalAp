package com.curso.android.app.practica.cursoargpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.practica.cursoargpro.R
import com.curso.android.app.practica.cursoargpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparacion.observe(this) {
            binding.cadena1.text = it.unaCadena
            binding.cadena2.text = it.otraCadena
        }

        binding.btnComparacion.setOnClickListener {
            mainViewModel.comparar()
        }
    }
}