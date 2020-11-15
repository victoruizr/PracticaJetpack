package com.example.practicajetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_navegador.*
import kotlinx.android.synthetic.main.fragment_principal.*

class Principal : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                System.exit(0)

                // in here you can do logic when backPress is clicked
            }
        })

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bCamara.setOnClickListener {
            val directions = PrincipalDirections.actionPrincipalToCamara()
            Navigation.findNavController(it).navigate(directions)
        }
        bNavegador.setOnClickListener {
            val directions2 = PrincipalDirections.actionPrincipalToNavegador()
            Navigation.findNavController(it).navigate(directions2)
        }
        bCalcular.setOnClickListener {
            val directions3 = PrincipalDirections.actionPrincipalToOperaciones()
            Navigation.findNavController(it).navigate(directions3)
        }
    }
}
