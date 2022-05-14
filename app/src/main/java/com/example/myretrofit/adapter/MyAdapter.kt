package com.example.myretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R
import com.example.myretrofit.model.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Post>()

     class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

         val user_Id = itemView.findViewById<TextView>(R.id.userId_txt)
         val id_txt = itemView.findViewById<TextView>(R.id.id_txt)
         val title_txt = itemView.findViewById<TextView>(R.id.title_txt)
         val body_txt = itemView.findViewById<TextView>(R.id.body_txt)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.user_Id.text = myList[position].userId.toString()
        holder.id_txt.text = myList[position].id.toString()
        holder.title_txt.text = myList[position].title
        holder.body_txt.text = myList[position].body

//        var infoUser = userlist[position]
//
//        holder.firstName.text = infoUser.FirstName
//        holder.lasttName.text = infoUser.LastName
    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }
}