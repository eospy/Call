package com.example.callapp.block

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callapp.R
import com.example.callapp.databinding.FragmentBlockBinding

class BlockFragment : Fragment() {

    private lateinit var binding: FragmentBlockBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_block, container,false)

        binding.rv.layoutManager = LinearLayoutManager(context)
        binding.rv.adapter = BlockBlackAdapter()

        return binding.root
    }

}