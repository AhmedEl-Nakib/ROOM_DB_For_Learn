package com.example.it_gate

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1) // define every table in array of entities , define version of db
abstract class AppDatabase  : RoomDatabase() {
    abstract fun userDao(): UserDao

}

// var x = AppDatabase() -> X