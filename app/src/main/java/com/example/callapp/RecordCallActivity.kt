package com.example.callapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.callapp.databinding.ActivityRecordCallBinding

class RecordCallActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecordCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_record_call)
    }
}