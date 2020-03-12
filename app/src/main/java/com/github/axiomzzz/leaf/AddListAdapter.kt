package com.github.axiomzzz.leaf

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.squareup.picasso.Picasso


object AddListAdapter:FirebaseRecyclerAdapter<ItemAddList, AddListAdapter.UserViewHolder>(optionsListAdd

){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        return UserViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.add_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: ItemAddList) {

        holder.name.text=model.name

        Picasso.get()
            .load(model.img)
            .apply {

                this.placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image)}

            .resize(100, 100)
            .centerCrop()
            .into(holder.avatar)


        holder.avatar.setOnClickListener {

            addUser(model.name,1)

            holder.avatar.setBackgroundColor(Color.parseColor("#64ffda"))



        }


    }

    fun addUser(name:String,weight:Int){
        val id= myRefList.push().key

        val newItem=ItemAddList(name=name,weight = weight)

        val itemValue=newItem.toMapCustom()

        val item=HashMap<String,Map<String,Any>>()

        id?.let { item.put(it,itemValue) }

        myRefList.updateChildren(item as Map<String, Any>)

    }
    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val avatar=itemView.findViewById<ImageView>(R.id.imageViewAddItem)

       val itemClick=itemView.findViewById<View>(R.id.item_click_add_list)

        val name=itemView.findViewById<TextView>(R.id.textViewAddItem)



    }

}





