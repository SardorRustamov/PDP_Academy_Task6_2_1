package com.example.pdpacademytask6_2_1.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pdpacademytask6_2_1.model.Contact

class DataBaseClass(context: Context) :SQLiteOpenHelper(
    context, DB_NAME, null, DB_VERSION), DataBaseService{

    companion object{
            const val DB_NAME = "contact_list"
            const val DB_VERSION = 1

            const val TABLE_NAME = "contact"
            const val CONTACT_ID = "id"
            const val CONTACT_NAME = "name"
            const val CONTACT_NUMBER = "number"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME  ($CONTACT_ID integer not null primary key autoincrement, $CONTACT_NAME text not null, $CONTACT_NUMBER text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun addContact(contact: Contact) {
        val database = this.writableDatabase

        val contentValues = ContentValues()

        contentValues.put(CONTACT_NAME, contact.name)
        contentValues.put(CONTACT_NUMBER, contact.number)

        database.insert(TABLE_NAME, null, contentValues)
    }

    @SuppressLint("Recycle")
    override fun listContact(): List<Contact> {
        var list = ArrayList<Contact>()

        val database = this.readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()){
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val number = cursor.getString(2)
                val contact = Contact(id, name, number)
                list.add(contact)
            }while (cursor.moveToNext())
        }

        return list
    }
}