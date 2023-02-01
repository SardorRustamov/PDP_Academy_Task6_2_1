package com.example.pdpacademytask6_2_1.database

import com.example.pdpacademytask6_2_1.model.Contact

interface DataBaseService {
    fun addContact(contact: Contact)

    fun listContact(): List<Contact>

}