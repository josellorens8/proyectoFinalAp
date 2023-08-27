package com.curso.android.app.practica.cursoargpro.view


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.cursoargpro.model.ComparacionResult

class MainViewModel : ViewModel() {
    private val _comparacion = MutableLiveData<ComparacionResult>(ComparacionResult("Resultado"))
    val comparacion: LiveData<ComparacionResult>
        get() = _comparacion

    fun comparar(cadena1: String, cadena2: String) {
        val resultado = if (cadena1 == cadena2) {
            "Las cadenas son iguales"
        } else {
            "Las cadenas no son iguales"
        }

        _comparacion.value = ComparacionResult(resultado)
    }
}