package com.example.mychat.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mychat.R
import com.example.mychat.all.AddContactDialog
import com.example.mychat.databinding.AllGroupsBinding
import com.google.firebase.firestore.FirebaseFirestore

class GroupsFragment:Fragment(R.layout.all_groups) {
    private lateinit var binding: AllGroupsBinding

    private var fb: FirebaseFirestore = FirebaseFirestore.getInstance()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = AllGroupsBinding.bind(view)

        binding.apply {

            addContact.setOnClickListener {
                val map = mapOf(
                    "id" to "121",
                     "name" to "Atabek"
                )

                fb.collection("chaty").add(
                    map
                ).addOnSuccessListener {

                }

            }



        }

    }

}