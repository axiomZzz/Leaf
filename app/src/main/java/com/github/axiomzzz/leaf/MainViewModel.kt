package com.github.axiomzzz.leaf

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainViewModel:ViewModel() {

    private val database = FirebaseDatabase.getInstance()
    val mAuth= FirebaseAuth.getInstance()

    private val user=mAuth.currentUser
    private val myRef = database.getReference("${mAuth.uid}")

    init {

      }


}