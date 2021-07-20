package com.example.callapp.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.callapp.R
import com.example.callapp.databinding.ItemAbcBinding

class ABCAdapter : RecyclerView.Adapter<ABCAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemAbcBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemAbcBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_abc,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 33
    }

}