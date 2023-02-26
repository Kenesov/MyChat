package com.example.mychat.ui.all

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mychat.Data.Group
import com.example.mychat.R
import com.example.mychat.ViewModel.ViewModelGroup
import com.example.mychat.databinding.DialogAddContactBinding
import java.util.*

class AddContactDialog: DialogFragment(R.layout.dialog_add_contact) {

    private lateinit var binding: DialogAddContactBinding
    private lateinit var viewModel: ViewModelGroup


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogAddContactBinding.bind(view)

        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(ViewModelGroup::class.java)

        binding.apply {

            btnAdd.setOnClickListener {

                val name = etName.text.toString()
                val uid = uniqueId()


                if (name.isNotEmpty() ){
                    lifecycleScope.launchWhenCreated {
                        viewModel.addGruop(
                            Group( uid,name)
                        )
                        onAddSuccess.invoke(uid)
                        viewModel.getGruop()
                        dismiss()
                    }

                }
            }
        }
    }
    private fun uniqueId():String = UUID.randomUUID().toString()

    private var onAddSuccess: (id: String) -> Unit = {}
    fun setOnAddSuccessListener(onAddSuccess: (id: String) -> Unit) {
        this.onAddSuccess = onAddSuccess
    }
}