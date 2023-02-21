package com.example.mychat.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mychat.Data.Chat
import com.example.mychat.R
import com.example.mychat.databinding.ItemChatBinding

class AdapterChat: RecyclerView.Adapter<AdapterChat.ViewHolder>() {

    var models = listOf<Chat>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemChatBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(chat: Chat){

        }
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        val binding = ItemChatBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind(models[position])
    }


}