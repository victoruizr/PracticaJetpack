package com.example.practicajetpack

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_operaciones.*
import kotlinx.android.synthetic.main.fragment_principal.*

class Operaciones : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_operaciones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bCalcula.setOnClickListener {

            try {
                if (radioButton.isChecked) {
                    var numero1 = Integer.parseInt(editTextNumber.text.toString())
                    var numero2 = Integer.parseInt(editTextNumber2.text.toString())
                    var result = numero1 + numero2
                    val directions = OperacionesDirections.actionOperacionesToSuma(resultado = result)
                    Navigation.findNavController(it).navigate(directions)
                }
                if (radioButton2.isChecked) {
                    var numero1 = Integer.parseInt(editTextNumber.text.toString())
                    var numero2 = Integer.parseInt(editTextNumber2.text.toString())
                    var result = numero1 - numero2
                    val directions1 = OperacionesDirections.actionOperacionesToResta(resultado = result)
                    Navigation.findNavController(it).navigate(directions1)

                }
                if (radioButton3.isChecked) {
                    var numero1 = Integer.parseInt(editTextNumber.text.toString())
                    var numero2 = Integer.parseInt(editTextNumber2.text.toString())
                    var result = numero1 * numero2
                    val directions2 = OperacionesDirections.actionOperacionesToMultplicacion(resultado = result)
                    Navigation.findNavController(it).navigate(directions2)

                }
                if (radioButton4.isChecked) {
                    var numero1 = Integer.parseInt(editTextNumber.text.toString())
                    var numero2 = Integer.parseInt(editTextNumber2.text.toString())
                    var result = numero1 / numero2.toFloat()
                    Log.d("AS", "" + result)
                    val directions3 = OperacionesDirections.actionOperacionesToDivision(resultado = result)
                    Navigation.findNavController(it).navigate(directions3)

                }
            } catch (e: Exception) {
                Toast.makeText(getActivity(),"Datos vacios",Toast.LENGTH_SHORT).show();
            }

        }

    }


}