package com.github.axiomzzz.leaf

import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

private val database = FirebaseDatabase.getInstance()
val mAuth= FirebaseAuth.getInstance()
val user=mAuth.currentUser

val myRefList= database.getReference("${mAuth.uid}")
val myRefAdd = database.getReference("base")

val optionsList= FirebaseRecyclerOptions.Builder<ItemList>().setQuery(myRefList,ItemList::class.java).build()
val optionsListAdd= FirebaseRecyclerOptions.Builder<ItemAddList>().setQuery(myRefAdd,ItemAddList::class.java).build()


