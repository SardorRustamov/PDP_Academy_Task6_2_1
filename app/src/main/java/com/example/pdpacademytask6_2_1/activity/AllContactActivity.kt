package com.example.pdpacademytask6_2_1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pdpacademytask6_2_1.R
import com.example.pdpacademytask6_2_1.adapter.ContactAdapter
import com.example.pdpacademytask6_2_1.database.DataBaseClass
import com.example.pdpacademytask6_2_1.databinding.ActivityAddContactBinding
import com.example.pdpacademytask6_2_1.databinding.ActivityAllContactBinding
import com.example.pdpacademytask6_2_1.model.Contact

class AllContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllContactBinding
    lateinit var dataBaseClass: DataBaseClass
    private lateinit var contactAdapter: ContactAdapter

    var list : ArrayList<Contact> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBaseClass = DataBaseClass(this)

        val listContact = dataBaseClass.listContact()

        contactAdapter = ContactAdapter(listContact)
        binding.rv.adapter=contactAdapter
    }
}