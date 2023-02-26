package com.example.mychat.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mychat.Data.Chat
import com.example.mychat.R
import com.example.mychat.databinding.ItemChatBinding
import com.google.protobuf.Internal.ListAdapter

class AdapterChat: androidx.recyclerview.widget.ListAdapter<String, AdapterChat.ChatViewHolder >(myDiffCallBack) {

    inner class ChatViewHolder(private val binding: ItemChatBinding) : ViewHolder(binding.root) {

        fun bind() {
         val d = getItem(adapterPosition)
            binding.yourText.text = d
            binding.myText.text = d
        }
    }

    private object myDiffCallBack : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent , false)
        val binding = ItemChatBinding.bind(view)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind()
    }
}