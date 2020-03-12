package com.github.axiomzzz.leaf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.delay


object ListAdapter:FirebaseRecyclerAdapter<ItemList, ListAdapter.UserViewHolder>(optionsList

){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

         return UserViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: ItemList) {

        holder.name.text=model.name

        holder.buttonDell.setOnClickListener {

            getRef(position).removeValue() /// Delete position

            holder.buttonDell.isEnabled

            
        }
    }



    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val buttonDell=itemView.findViewById<Button>(R.id.buttonAddListItem)

        val name=itemView.findViewById<TextView>(R.id.textViewAddListItem)



    }

}





