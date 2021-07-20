package com.example.callapp.block

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.callapp.R
import com.example.callapp.databinding.ActivityBlockCallBinding

class BlockCallActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlockCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_block_call)
    }
}