package com.example.practicajetpack

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_camara.*

/**
 * A simple [Fragment] subclass.
 * Use the [Camara.newInstance] factory method to
 * create an instance of this fragment.
 **/

class Camara : Fragment() {
    val REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camara, container, false)
    }




    //FOTO
    fun hacerFoto() {
        val permissionCheck = context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA)  }
        if(permissionCheck==PackageManager.PERMISSION_GRANTED){
            val callCamaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(callCamaraIntent.resolveActivity(requireActivity().packageManager)!=null){
                this.startActivityForResult(callCamaraIntent,REQUEST_IMAGE_CAPTURE)
            }
        }else{
            ActivityCompat.requestPermissions(
                    (context as Activity)!!,
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_IMAGE_CAPTURE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode==Activity.RESULT_OK&&data !=null) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bFoto.setOnClickListener {
            hacerFoto()
        }
    }


}