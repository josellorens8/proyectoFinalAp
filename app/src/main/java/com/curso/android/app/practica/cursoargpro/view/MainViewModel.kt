package com.curso.android.app.practica.cursoargpro.view

import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.cursoargpro.R
import com.curso.android.app.practica.cursoargpro.model.Comparacion
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val comparacion: LiveData<Comparacion> get() = _compara
    private var _compara = MutableLiveData<Comparacion>(Comparacion("", ""))


    private fun comparar() {
    }

}