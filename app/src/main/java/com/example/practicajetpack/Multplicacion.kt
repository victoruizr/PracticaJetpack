package com.example.practicajetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_suma.*


/**
 * A simple [Fragment] subclass.
 * Use the [Multplicacion.newInstance] factory method to
 * create an instance of this fragment.
 */
class Multplicacion : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multplicacion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val resultado = MultplicacionArgs.fromBundle(it).resultado;
            Resultado.setText("La Multiplicacion es "+resultado.toString())
        }
    }
}