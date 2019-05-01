package com.birjuvachhani.bottomdialogsample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.birjuvachhani.bottomdialog.BottomDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDialog(view: View) {
        BottomDialog.Builder(this)
            .setTitle("Hello")
            .setMessage("This is a custom dialog message!")
            .setPositiveButton("Yes") {
                Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {
                Toast.makeText(this, "NegativeButton Clicked", Toast.LENGTH_SHORT).show()
            }
            .build()
            .show()
    }
}
