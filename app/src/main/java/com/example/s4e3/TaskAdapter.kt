package com.example.s4e3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.res.Configuration;
import com.example.s4e3.R

class TaskAdapter(var msg: List<Task> , comunication: Comunication):RecyclerView.Adapter<TaskAdapter.ViewHolder>(){
    private lateinit var comm: Comunication


    var tasks = ArrayList<Task>()


    private  var dataSet= arrayListOf<Task>()

    init {
        comm = comunication ;
        dataSet.addAll(msg)
        tasks = dataSet
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): ViewHolder {
        val viewObj = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return ViewHolder(viewObj)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvName.text = tasks[position].name.toString()
        holder.tvDate.text = tasks[position].date.getDate().toString()+"/"+(tasks[position].date.getMonth()+1).toString()+"/"+tasks[position].date.getYear().toString()

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val deleted_task = tasks[position] ;
                tasks.remove(tasks[position]) ;
                notifyDataSetChanged()
                comm.passDataCom(deleted_task)



                //val livrePageFragment = LivrePageFragment(tasks[position])

                val orientation: Int = activity.getResources().getConfiguration().orientation
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    // In landscape
                  //  activity.supportFragmentManager.beginTransaction().apply {
                    //    replace(R.id.fl2Fragment,  livrePageFragment)
                      //  addToBackStack(null)
                       // commit()
                   // }
                } else {
                    // In portrait
                    //activity.supportFragmentManager.beginTransaction().apply {
                      //  replace(R.id.flFragment,  livrePageFragment)
                        //addToBackStack(null)
                       //commit()
                    //}
                }


            }
        }
        )
    }

    override fun getItemCount(): Int {
        return tasks.size
    }


}