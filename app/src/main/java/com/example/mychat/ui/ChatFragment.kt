package com.example.mychat.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mychat.R
import com.example.mychat.databinding.AllChatBinding

class ChatFragment:Fragment(R.layout.all_chat) {
    private lateinit var binding: AllChatBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = AllChatBinding.bind(view)

        binding.apply {

        }
    }
}