package com.github.axiomzzz.leaf

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels



import kotlinx.android.synthetic.main.activity_registration.*



class RegistrationActivity : AppCompatActivity() {

    private val PREF_NAME="PrefName"
    private val PREF_EMAIL="PreMail"
    private val PREF_PASSWORD="PrefPass"

   private val model: MainViewModel by viewModels()



    private val sharedPref:SharedPreferences by lazy {
        getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

// AutoEnter!!!!!
//        sharedPref.let {
//            signing(it.getString(PREF_EMAIL,"test@test.com").toString(),it.getString(PREF_PASSWORD,"123456").toString())
//        }


        buttonEnter.setOnClickListener {

            sharedPref.edit().apply {
                putString(PREF_EMAIL,editTextEmail.text.toString())
                putString(PREF_PASSWORD,editTextPassword.text.toString())
                apply()
            }

          signing(editTextEmail.text.toString(),editTextPassword.text.toString())
        }

        buttonRegistration.setOnClickListener {

            registration(editTextEmail.text.toString(),editTextPassword.text.toString())
        }
}

    private fun signing(email:String,password:String){


        model.mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {

            if(it.isSuccessful){
                Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
            }
            else{
                Toast.makeText(this,"Fail", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registration(email:String,password:String){
        model.mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {

            if(it.isSuccessful){
                Toast.makeText(this,"Registration Complete", Toast.LENGTH_SHORT).show()}

        }
    }
}
