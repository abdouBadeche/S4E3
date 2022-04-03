package com.example.s4e3

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_livre_fragment.*
import java.text.SimpleDateFormat
import java.util.*


var tasks : List<Task> =  listOf(
    Task("Task 1" , Date(2022 , 3 , 3 )) ,
    Task("Task 2" , Date(2022 , 3 , 3) ) ,
    Task("Task 2" , Date(2022 , 3 , 4) )
) ;

class MainActivity : AppCompatActivity() , Comunication {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var today : Calendar = Calendar.getInstance() ;
        var this_year = today.get(Calendar.YEAR) ;


        typeFilter.text = "Aujourd'hui"

        val new_tasks = tasks.filter {
            it.date.equals(Date(today.get(Calendar.YEAR)  , today.get(Calendar.MONTH)  , today.get(Calendar.DAY_OF_MONTH) ))
        }

        val listFragment = ListFragment(new_tasks!!)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,  listFragment)
            commit()
        }

        button.setOnClickListener{ view ->
            clickDatePicker(view)
        }

        btnToday.setOnClickListener {

            var today : Calendar = Calendar.getInstance() ;
            var this_year = today.get(Calendar.YEAR) ;


            typeFilter.text = "Aujourd'hui"

            val new_tasks = tasks.filter {
                it.date.equals(Date(today.get(Calendar.YEAR)  , today.get(Calendar.MONTH)  , today.get(Calendar.DAY_OF_MONTH) ))
            }
            val listFragment = ListFragment(new_tasks!!)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,  listFragment)
                commit()
            }
        }

        btnWeek.setOnClickListener {

            typeFilter.text = "Cette Semaine"

            val new_tasks = tasks.filter {
                it.date.equals(Date())
            }
            val listFragment = ListFragment(new_tasks!!)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,  listFragment)
                commit()
            }
        }

        btnAll.setOnClickListener {

            typeFilter.text = "Toutes"

            val listFragment = ListFragment(tasks!!)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,  listFragment)
                commit()
            }
        }
    }

    fun clickDatePicker(view : View) {
        if(tvNew.text.toString().length == 0 ) {
            Toast.makeText(applicationContext,"Remplir le nom de la tache STP !!",Toast.LENGTH_SHORT).show()
        }else {
            var today : Calendar = Calendar.getInstance() ;
            var year = today.get(Calendar.YEAR)
            var month = today.get(Calendar.MONTH)
            var day = today.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this  ,
                DatePickerDialog.OnDateSetListener {
                        view, year, month, dayOfMonth ->
                    DateChange(year , month , dayOfMonth)

                } , year , month ,day
            ).show()

        }
    }

    fun DateChange(year:Int , month:Int  , dayOfMonth:Int ) {

        var today : Calendar = Calendar.getInstance() ;
        var this_year = today.get(Calendar.YEAR) ;


        typeFilter.text = "Aujourd'hui"

        val new_tasks = tasks.filter {
            it.date.equals(Date(today.get(Calendar.YEAR)  , today.get(Calendar.MONTH)  , today.get(Calendar.DAY_OF_MONTH) ))
        }

        tasks += Task(tvNew.text.toString() , Date(year , month , dayOfMonth))
        val listFragment = ListFragment(new_tasks!!)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,  listFragment)
            commit()
        }
    }

    override fun passDataCom(element: Task) {
        tasks -= element
    }
}