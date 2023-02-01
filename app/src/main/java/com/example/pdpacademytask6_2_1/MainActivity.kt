package com.example.pdpacademytask6_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pdpacademytask6_2_1.activity.AddContactActivity
import com.example.pdpacademytask6_2_1.activity.AllContactActivity
import com.example.pdpacademytask6_2_1.database.DataBaseClass
import com.example.pdpacademytask6_2_1.databinding.ActivityMainBinding
import com.example.pdpacademytask6_2_1.model.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var dataB: DataBaseClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataB = DataBaseClass(this)

        binding.addContact.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        })

        binding.contactList.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AllContactActivity::class.java)
            startActivity(intent)
        })
    }
}