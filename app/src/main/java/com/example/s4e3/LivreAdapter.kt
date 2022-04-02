package com.example.mybib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.res.Configuration;
import com.example.s4e3.R

class LivreAdapter(var msg: List<Livre>):RecyclerView.Adapter<LivreAdapter.ViewHolder>(){


    var livres = ArrayList<Livre>()


    private  var dataSet= arrayListOf<Livre>()

    init {
        dataSet.addAll(msg)
        livres = dataSet
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitre: TextView = itemView.findViewById(R.id.tvTitre)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewObj = LayoutInflater.from(parent.context).inflate(R.layout.livre_item, parent, false)
        return ViewHolder(viewObj)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitre.text = livres[position].titre.toString()

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity

                val livrePageFragment = LivrePageFragment(livres[position])

                val orientation: Int = activity.getResources().getConfiguration().orientation
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    // In landscape
                    activity.supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl2Fragment,  livrePageFragment)
                        addToBackStack(null)
                        commit()
                    }
                } else {
                    // In portrait
                    activity.supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment,  livrePageFragment)
                        addToBackStack(null)
                        commit()
                    }
                }


            }
        }
        )
    }

    override fun getItemCount(): Int {
        return livres.size
    }


}