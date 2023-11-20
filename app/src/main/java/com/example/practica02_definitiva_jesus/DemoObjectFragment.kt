package com.example.practica02_definitiva_jesus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.practica02_definitiva_jesus.Data.Student
import com.example.practica02_definitiva_jesus.Data.Tutor

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var calendarUser:ImageButton


private const val ARG_OBJECT = "object"
class DemoObjectFragment : Fragment() {

    private var imageUserView: ImageView? = null
    private var nameUserView: TextView? = null
    private var surnameUserView: TextView? = null
    private var emailUserView: TextView? = null
    private var cityUserView: TextView? = null
    private var centerUserView: TextView? = null
    private var tutorUserView: TextView? = null



    val StudentList = listOf(
        Student("Jesus Miguel", "Perez Rico", "jesusmi.perez@alten.es","IES Martinez Montañes", "Sevilla",R.drawable.icon_user),
        Student("Daniel", "Jimenez", "dani.jimenez@alten.es","IES Alcores", "Huelva",R.drawable.icon_user),
        Student("Alfredo", "Martin" , "alfre.martin@alten.es","IES Blas Infante", "Malaga", R.drawable.icon_user)
    )

    val TutorList = listOf(
        Tutor("Manuel", "Falcon"),
        Tutor("Juan", "Pacheco"),
        Tutor("Antonio", "Sanchez"),
    )

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_object, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {


            val student= StudentList[getInt(ARG_OBJECT)]
            imageUserView = view.findViewById(R.id.imageUser)
            student?.imageUser?.let { imageUserView?.setImageResource(it) }

            nameUserView = view.findViewById(R.id.nameUser)
            nameUserView?.text = student.nombre

            surnameUserView = view.findViewById(R.id.surnameUser)
            surnameUserView?.text = student.apellidos

            emailUserView = view.findViewById(R.id.emailUser)
            emailUserView?.text = student.email

            cityUserView = view.findViewById(R.id.cityUser)
            cityUserView?.text = student.ciudad

            centerUserView = view.findViewById(R.id.centerUser)
            centerUserView?.text = student.centro




            val tutor= TutorList[getInt(ARG_OBJECT)]
            tutorUserView = view.findViewById(R.id.tutorUser)
            val tutorname= tutor.nombre
            val tutorsurname=tutor.apellidos
            tutorUserView?.text = tutorname+" "+ tutorsurname


            calendarUser=view.findViewById(R.id.calendarUser)



            calendarUser.setOnClickListener {

                val intent = Intent(activity,AttendanceActivity::class.java)
                intent.putExtra("student",student)
                startActivity(intent)

            }


        }

    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DemoObjectFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DemoObjectFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}



