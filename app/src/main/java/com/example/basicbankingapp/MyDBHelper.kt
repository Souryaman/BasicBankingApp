package com.example.basicbankingapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context): SQLiteOpenHelper(context,"CUSTOMERS_DATA",null,1) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CUSTOMERS_DATA"
        private const val TABLE_NAME = "CUSTOMERS"

        private const val CUSTOMER_ID = "cid"
        private const val FNAME = "FirstName"
        private const val LNAME = "LastName"
        private const val EMAIL = "email"
        private const val BALANCE = "balance"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE CUSTOMERS(cid INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT,EMAIL TEXT,BALANCE INTEGER)")

        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Souryaman','Singh','souryamanhp99@gmail.com',9000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Kartikey','Vaish','kartikeyvaish99@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Shorya','Bansal','shoryabhuvi7651@gmail.com',11000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Kislay','Singh','singhkislay1101@gmail.com',8000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Utsav','Verma','utsavverma21@gmail.com',6000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Vivek','Sherkhane','sherkanevivek@gmail.com',5000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Gaurav','Shriwastav','gaurav9812@gmail.com',4000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Raunak','Kumar','kumarraunak123@gmail.com',5000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Amit','Raman','amitraman@gmail.com',15000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Aryaman','Singh','singharyaman712@gmail.com',4000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Mohit','Kumar','kumarmohit@gmail.com',25000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Utkarsh','Tulsiyan','tulsiyanutkarsh@gmail.com',45000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Gyanesh','Jha','jhagyanesh121@gmail.com',510000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Rohit','Kumar','kumarrohit@gmail.com',1000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Satyendra','Kumar','kumarsatyendra12@gmail.com',3000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Nishant','Sharma','sharmanishant@gmail.com',70000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Udayan','Singh','singhudayan007@gmail.com',80000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Nipun','Jain','nipun32111@gmail.com',13000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Rahul','Roy','royrahul@gmail.com',15000)")


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun updateBalance(c: Customer) {
        val values = ContentValues()
        values.put(BALANCE, c.getBalance())

        val db: SQLiteDatabase = this.writableDatabase
        //val success = db.update(TABLE_CONTACTS, contentValues,"id="+emp.userId,null)
        val success = db.update(
            TABLE_NAME,
            values,
            " cid = " + c.getId(),
            null)

    }

}