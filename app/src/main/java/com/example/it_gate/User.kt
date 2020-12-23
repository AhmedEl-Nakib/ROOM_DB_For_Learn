package com.example.it_gate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // this annotation make room notice that this data class is a table in database
data class User (
    @ColumnInfo(name = "userName")  // define column in this table
    var name :String,
    @ColumnInfo(name ="userAddress") // define column in this table
    var address :String) {

    @PrimaryKey(autoGenerate = true) var id:Int = 0
}


//TableName = User
//Col1 = userName
//Col2 = userAddress