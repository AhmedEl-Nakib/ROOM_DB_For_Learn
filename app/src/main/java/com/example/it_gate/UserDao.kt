package com.example.it_gate

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

// add every method you need to access database
@Dao
interface UserDao {
    // INSERT
    @Insert
    fun insertNewUser(user : User)

    // SELECT
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE id=:id")
    fun getUserById(id :Int) :List<User>


    //DELETE
    @Query("DELETE FROM User")
    fun deleteAllTableData()

    @Query("DELETE FROM User WHERE id = :id")
    fun deleteUserById(id : Int)

    //Update
    @Query("UPDATE User SET userName = :name , userAddress = :address WHERE id = :id")
    fun updateUser(id:Int , name:String , address:String)


}

// @Annotation (INSERT , DELETE , UPDATE ) , @Query ( INSERT , UPDATE , DELETE , SELECT )