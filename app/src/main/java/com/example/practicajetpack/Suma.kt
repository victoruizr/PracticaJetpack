package com.example.practicajetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicajetpack.DivisionArgs.Companion.fromBundle
import com.example.practicajetpack.MultplicacionArgs.Companion.fromBundle
import com.example.practicajetpack.RestaArgs.Companion.fromBundle
import kotlinx.android.synthetic.main.fragment_principal.*
import kotlinx.android.synthetic.main.fragment_suma.*


class Suma : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suma, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val resultado = SumaArgs.fromBundle(it).resultado;
            Resultado.setText("La suma es "+resultado.toString())
        }
    }

}