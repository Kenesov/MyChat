package com.example.mychat.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mychat.Data.Group
import com.example.mychat.R
import com.example.mychat.databinding.ItemGruopBinding

class AdapterGroup: RecyclerView.Adapter<AdapterGroup.ViewHolder>() {

    var models = listOf<Group>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemGruopBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(group: Group){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gruop, parent, false)
        val binding = ItemGruopBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
      return models.size
    }
}