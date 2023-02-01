package com.example.pdpacademytask6_2_1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pdpacademytask6_2_1.database.DataBaseClass
import com.example.pdpacademytask6_2_1.databinding.ActivityAddContactBinding
import com.example.pdpacademytask6_2_1.model.Contact

class AddContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddContactBinding
    lateinit var dataBaseClass: DataBaseClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBaseClass=DataBaseClass(this)

        binding.addContact.setOnClickListener(View.OnClickListener {

            val name = binding.editTxtName.text.toString()
            val number = binding.editTxtNumber.text.toString()

            val contact = Contact(name = name, number = number)

            dataBaseClass.addContact(contact)

            Toast.makeText(this, "Kontakt qo'shildi", Toast.LENGTH_SHORT).show()
            finish()
        })
    }
}