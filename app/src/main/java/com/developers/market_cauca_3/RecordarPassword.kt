package com.developers.market_cauca_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecordarPassword : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordar_password)

        val txtemail : TextView = findViewById(R.id.txtEmail3)
        val btnCambiar : Button = findViewById(R.id.btnRestaurar)

        btnCambiar.setOnClickListener()
        {
            sendPasswordReset(txtemail.text.toString())
        }

        firebaseAuth = Firebase.auth

    }

    private fun sendPasswordReset (email:String)
    {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener(){
                task ->
                if (task.isSuccessful)
                {
                    Toast.makeText(baseContext,"Correo enviado exitosamente", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(baseContext,"Error, no es valida", Toast.LENGTH_LONG).show()

                }
            }

    }
}