package com.developers.market_cauca_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnregister : Button = findViewById(R.id.btnRegister)
        val txtemail : TextView = findViewById(R.id.txtEmail)
        val txtpassword : TextView = findViewById(R.id.txtPassword)
        val btnRecordar : TextView = findViewById(R.id.txtRecordar)

        val btnCrear_CuentaNueva : TextView = findViewById(R.id.btnCrear)
        firebaseAuth = Firebase.auth
        btnregister.setOnClickListener()
        {
            signIn(txtemail.text.toString(), txtpassword.text.toString())
        }
        btnCrear_CuentaNueva.setOnClickListener()
        {
            val i = Intent(this, Login::class.java)
            startActivity(i)
        }
        btnRecordar.setOnClickListener()
        {
            val i = Intent(this,RecordarPassword::class.java)
            startActivity(i)
        }
    }

    private fun signIn(email: String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            task->

            if (task.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext,"Autenticacion Exitosa", Toast.LENGTH_SHORT).show()
                //Aqui vamos a ir a la segunda activity
                val i = Intent( this, MainActivity2::class.java )
                startActivity(i)
            }else
            {
                Toast.makeText(baseContext,"Error de Email y/o Contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }
}