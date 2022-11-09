package com.developers.market_cauca_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val txtNewName : TextView = findViewById(R.id.txtName)
        val txtEmail : TextView = findViewById(R.id.txtEmail2)
        val txtPassword1 : TextView = findViewById(R.id.txtPassword2)
        val txtPassword2 : TextView = findViewById(R.id.txtPasswordSuccess)
        val btnCrear : Button = findViewById(R.id.btnCrear2)
        btnCrear.setOnClickListener()
        {
            var pass1 = txtPassword1.text.toString()
            var pass2 = txtPassword2.text.toString()
            if (pass1.equals(pass2))
            {
                createAccount(txtEmail.text.toString(), txtPassword1.text.toString())
            }else
            {
                Toast.makeText(baseContext, "Error: Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                txtPassword1.requestFocus()
            }
        }

        firebaseAuth = Firebase.auth

    }
    private fun createAccount(email: String, password: String)
    {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
            Tasks ->

            if (Tasks.isSuccessful)
            {
                Toast.makeText(baseContext, "Cuenta creada correctamente", Toast.LENGTH_LONG).show()
            }else
            {
                Toast.makeText(baseContext, "Algo salio mal, Error: " + Tasks.exception,Toast.LENGTH_LONG).show()
            }
        }
    }
}