package com.example.callapp.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.callapp.R
import com.example.callapp.databinding.ItemContactBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemContactBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_contact,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }


}