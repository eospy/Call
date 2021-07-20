package com.example.callapp.contact

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.loader.app.LoaderManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callapp.NavigationActivity
import com.example.callapp.R
import com.example.callapp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    companion object {
        val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false)
// TODO: получение списка контактов
//        (activity as NavigationActivity).loadContacts()

        binding.rvContacts.layoutManager = LinearLayoutManager(context)
        binding.rvContacts.adapter = ContactAdapter()

        binding.rvAbc.layoutManager = LinearLayoutManager(context)
        binding.rvAbc.adapter = ABCAdapter()

        return binding.root
    }



}