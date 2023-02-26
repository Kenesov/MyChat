package com.example.mychat.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mychat.Adapter.AdapterGroup
import com.example.mychat.R
import com.example.mychat.ViewModel.ViewModelGroup
import com.example.mychat.ui.all.AddContactDialog
import com.example.mychat.databinding.AllGroupsBinding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class GroupsFragment:Fragment(R.layout.all_groups) {

    private lateinit var binding: AllGroupsBinding
    private val adapter = AdapterGroup()
    private lateinit var viewModel: ViewModelGroup

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AllGroupsBinding.bind(view)

        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(ViewModelGroup::class.java)

        initObservers()

        binding.apply {
            groupRecyclerView.adapter = adapter

            groupRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            lifecycleScope.launchWhenResumed {
                viewModel.getGruop()
            }

            adapter.setOnItemClickListener { id->
                val bundle = Bundle()
               bundle.putString("id", id)
                findNavController().navigate(R.id.action_groupsFragment_to_chatFragment, bundle)
            }

            addContact.setOnClickListener {

                val dialog = AddContactDialog()
                dialog.show(requireActivity().supportFragmentManager, dialog.tag)
            }
        }
    }

    private fun initObservers() {
        viewModel.activeUsersFlow.onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }

    }

