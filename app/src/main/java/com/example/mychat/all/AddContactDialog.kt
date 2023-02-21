package com.example.mychat.all

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.mychat.Data.Group
import com.example.mychat.R
import com.example.mychat.databinding.DialogAddContactBinding

class AddContactDialog: DialogFragment(R.layout.dialog_add_contact) {

    private lateinit var binding: DialogAddContactBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogAddContactBinding.bind(view)

        binding.apply {

            btnAdd.setOnClickListener {

                val name = etName.text.toString()
                val phone = etPhone.text.toString()

                if (name.isNotEmpty() && phone.isNotEmpty()){
                    val contact = Group(
                        name = name,
                        image = 1
                    )
                }
            }
        }
    }
}