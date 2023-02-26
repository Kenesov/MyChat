package com.example.mychat.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mychat.Data.Group
import com.example.mychat.R
import com.example.mychat.databinding.ItemGruopBinding
import com.google.firebase.firestore.auth.User

class AdapterGroup: ListAdapter<Group, AdapterGroup.GroupViewHolder>(diffUtilCallBack) {

    inner class GroupViewHolder(private val binding: ItemGruopBinding): ViewHolder(binding.root){

        fun bind(){

            val d = getItem(adapterPosition)

            binding.apply {
                contactName.text = d.name

                contactName.setOnClickListener {
                    onItemClick.invoke(d.id.toString())
                }
            }

        }
    }

    private object diffUtilCallBack: DiffUtil.ItemCallback<Group>() {
        override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
            return  oldItem == newItem
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(
            ItemGruopBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_gruop, parent, false))
        )
    }

    private var onItemClick: (id: String) -> Unit = {}
    fun setOnItemClickListener(onItemClick: (id: String) -> Unit) {
        this.onItemClick = onItemClick
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind()
    }

}