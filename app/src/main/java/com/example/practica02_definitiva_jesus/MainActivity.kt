package com.example.practica02_definitiva_jesus

import ViewPagerAdapter
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.viewpager2.widget.ViewPager2
import com.example.practica02_definitiva_jesus.Data.Student
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private val adapter by lazy { ViewPagerAdapter(this)



        }

    val StudentList = listOf(
       Student("Jesus Miguel", "Perez Rico", "jesusmi.perez@alten.es","IES Martinez Montañes", "Sevilla",R.drawable.icon_user),
       Student("Daniel", "Jimenez", "dani.jimenez@alten.es","IES Alcores", "Huelva",R.drawable.icon_user),
       Student("Alfredo", "Martin" , "alfre.martin@alten.es","IES Blas Infante", "Malaga",R.drawable.icon_user)
       )



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pager: ViewPager2 = findViewById(R.id.pager)
        pager.adapter = adapter
        val tab_layout:TabLayout = findViewById(R.id.tab_layout)



        val tabLayoutMediator = TabLayoutMediator(tab_layout,pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position + 1) {
                    1 -> {
                        val student= StudentList[0]
                        val usernameLayout= student.email.substringBefore('@')
                        tab.text = usernameLayout
                    }

                    2 -> {
                        val student= StudentList[1]
                        val usernameLayout= student.email.substringBefore('@')
                        tab.text = usernameLayout
                    }

                    3 -> {
                        val student= StudentList[2]
                        val usernameLayout= student.email.substringBefore('@')
                        tab.text = usernameLayout
                    }
                }
            })
        tabLayoutMediator.attach()




    }



}