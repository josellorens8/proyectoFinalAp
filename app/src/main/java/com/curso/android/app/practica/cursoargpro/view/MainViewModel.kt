package com.curso.android.app.practica.cursoargpro.view

import android.text.Editable
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.cursoargpro.model.Comparacion
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val comparacion: LiveData<Comparacion> get() = _compara
    private var _compara = MutableLiveData<Comparacion>(Comparacion("Hola mundo", "", ""))

    fun comparar(cadenaPrimera: EditText, cadenaSegunda: EditText) {
        _compara.value?.unaCadena = cadenaPrimera.toString()
        _compara.value?.otraCadena = cadenaSegunda.toString()

        val comparacionCadenas:Boolean = cadenaPrimera == cadenaSegunda
        enviar(comparacionCadenas)
    }

    private fun enviar(resultado: Boolean){

        if (resultado){
            viewModelScope.launch {
                _compara.value?.msj = "Las cadenas son iguales"
            }
        } else {
            viewModelScope.launch {
                _compara.value?.msj = "Las cadenas no son iguales"
            }
        }

    }

}