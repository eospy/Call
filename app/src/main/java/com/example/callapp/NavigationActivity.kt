package com.example.callapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.callapp.block.BlockFragment
import com.example.callapp.contact.ContactFragment
import com.example.callapp.contact.ContactFragment.Companion.PERMISSIONS_REQUEST_READ_CONTACTS
import com.example.callapp.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    private lateinit var lastSelectView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation)

        binding.listener = this

    }

    fun onViewClick(view: View) {
        when (view.id) {
            binding.llBlock.id -> {
                binding.tvBlock.setTextColor(Color.WHITE)
                binding.llBlock.setBackgroundResource(R.drawable.btn_circle_dark)

                supportFragmentManager.beginTransaction()
                    .replace(binding.container.id, BlockFragment())
                    .commit()
            }
            binding.llContact.id -> {
                binding.tvContact.setTextColor(Color.WHITE)
                binding.llContact.setBackgroundResource(R.drawable.btn_circle_dark)

                supportFragmentManager.beginTransaction()
                    .replace(binding.container.id, ContactFragment())
                    .commit()
            }
            binding.llLog.id -> {

            }
            binding.llPremium.id -> {

                binding.tvPremium.setTextColor(Color.WHITE)
                binding.llPremium.setBackgroundResource(R.drawable.btn_circle_dark)

                supportFragmentManager.beginTransaction()
                    .replace(binding.container.id, PremiumFragment())
                    .commit()
            }
            binding.llSettings.id -> {
                binding.tvSettings.setTextColor(Color.WHITE)
                binding.llSettings.setBackgroundResource(R.drawable.btn_circle_dark)

                supportFragmentManager.beginTransaction()
                    .replace(binding.container.id, SettingsFragment())
                    .commit()
            }
        }
    }

    fun loadContacts() {
        var builder = StringBuilder()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS)
            //callback onRequestPermissionsResult
        } else {
            builder = getContacts()
            Log.d("tag", "loadContacts: ${builder}")
//            listContacts.text = builder.toString()
        }
    }

    private fun getContacts(): StringBuilder {
        val builder = StringBuilder()
        val resolver: ContentResolver = contentResolver;
        val cursor = resolver.query(
            ContactsContract.Contacts.CONTENT_URI, null, null, null,
            null)

        if (cursor?.count!! > 0) {
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val phoneNumber = (cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))).toInt()

                if (phoneNumber > 0) {
                    val cursorPhone = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", arrayOf(id), null)

                    if(cursorPhone?.count!! > 0) {
                        while (cursorPhone.moveToNext()) {
                            val phoneNumValue = cursorPhone.getString(
                                cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            builder.append("Contact: ").append(name).append(", Phone Number: ").append(
                                phoneNumValue).append("\n\n")
                            Log.e("Name ===>",phoneNumValue);
                        }
                    }
                    cursorPhone.close()
                }
            }
        } else {
            Log.d("tag", "getContacts: not contacts available")
        }
        cursor.close()
        return builder
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                Log.d("tag", "Permission must be granted in order to display " +
                        "contacts information")
            }
        }
    }

}