package com.curso.android.app.practica.cursoargpro

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.cursoargpro.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    private lateinit var  viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparacion.value?.msj
        assertEquals( "Resultado", value)
    }

    @Test
    fun mainViewModel_TestStringNotEquals() = runTest {
        launch {
            viewModel.comparar("a", "b")
        }

        advanceUntilIdle()

        val value = viewModel.comparacion.value?.msj
        assertEquals("Las cadenas no son iguales", value)
    }

    @Test
    fun mainViewModel_TestStringEquals() = runTest {
        launch {
            viewModel.comparar("a", "a")
        }

        advanceUntilIdle()

        val value = viewModel.comparacion.value?.msj
        assertEquals("Las cadenas son iguales", value)
    }

}