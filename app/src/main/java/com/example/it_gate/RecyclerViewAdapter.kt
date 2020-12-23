package com.example.it_gate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class RecyclerViewAdapter (private val dataSet: List<User>,var context:Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var name: TextView
        lateinit var address: TextView
        lateinit var id: TextView
        lateinit var mainLayout : LinearLayout
        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.nameId)
            address = view.findViewById(R.id.addressId)
            id = view.findViewById(R.id.idId)
            mainLayout = view.findViewById(R.id.mainId)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.name.text = dataSet[position].name
        viewHolder.address.text = dataSet[position].address
        viewHolder.id.text = dataSet[position].id.toString()
        viewHolder.mainLayout.setOnClickListener {

            val db = Room.databaseBuilder(context, AppDatabase::class.java, "userDB")
                .allowMainThreadQueries().build()
            db.userDao().deleteUserById(dataSet[position].id.toString().toInt())
            Toast.makeText(context, "User Deleted", Toast.LENGTH_SHORT).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
