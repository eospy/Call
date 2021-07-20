package com.example.callapp.block

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.callapp.R
import com.example.callapp.databinding.ActivityBlockDontDisturbBinding

class BlockDontDisturbActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlockDontDisturbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_block_dont_disturb)
    }
}