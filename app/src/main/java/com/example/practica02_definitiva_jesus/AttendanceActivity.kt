package com.example.practica02_definitiva_jesus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.practica02_definitiva_jesus.data.Student

private var toolbar: Toolbar? = null
private var imageUserView: ImageView? = null
private var nameUserLayout:Toolbar?=null

class AttendanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        val intent = intent
        val student = intent.getSerializableExtra("student") as? Student
        val userImageView = findViewById<ImageView>(R.id.imageUser)
        student?.imageUser?.let { userImageView.setImageResource(it) }
        val nameUserView = findViewById<TextView>(R.id.nameUserLayout)
        nameUserView.text = student?.name.orEmpty()
        val surnameUserView = findViewById<TextView>(R.id.surnameUserLayout)
        surnameUserView.text = student?.surname.orEmpty()

        toolbar = findViewById (R.id.toolbar)
        setSupportActionBar(toolbar)




    }


}

