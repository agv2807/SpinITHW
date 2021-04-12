package com.example.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var array = arrayListOf<Message>()

    fun setData(messages: ArrayList<Message>){
        array = messages
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {

        return if (array[position].isMy) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val vh = if (viewType == 0){
             ViewHolderGreen(LayoutInflater.from(parent.context).inflate(R.layout.my_message, parent, false))

        }else{
             ViewHolderGray(LayoutInflater.from(parent.context).inflate(R.layout.other_message, parent, false))
        }
        return vh
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (array[position].isMy){
            var holdercustom = holder as ViewHolderGreen
            holdercustom.bind(array[position])
        }else{
            var holdercustom = holder as ViewHolderGray
            holdercustom.bind(array[position])
        }
    }

    inner class ViewHolderGray(ItemView: View): RecyclerView.ViewHolder(ItemView){

        fun bind(str: Message){

            val textView = itemView.findViewById<TextView>(R.id.otherMessage)
            textView.text = str.text
        }
    }

    inner class ViewHolderGreen(ItemView: View): RecyclerView.ViewHolder(ItemView){

        fun bind(str: Message){

            val textView = itemView.findViewById<TextView>(R.id.myMessage)
            textView.text = str.text
        }
    }
}