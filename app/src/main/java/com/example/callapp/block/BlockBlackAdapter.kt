package com.example.callapp.block

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.callapp.R
import com.example.callapp.databinding.ItemBlackListBinding

class BlockBlackAdapter : RecyclerView.Adapter<BlockBlackAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemBlackListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemBlackListBinding = DataBindingUtil.inflate(inflater, R.layout.item_black_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }

}