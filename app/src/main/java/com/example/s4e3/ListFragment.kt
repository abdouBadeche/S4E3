package com.example.s4e3

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class ListFragment (var list: List<Task>) : Fragment(R.layout.recycler_livre_fragment){

    private lateinit var comm: Comunication

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<TaskAdapter.ViewHolder>? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comm = requireActivity() as Comunication

        layoutManager = LinearLayoutManager(requireContext())


        val recyclerView = view?.findViewById<RecyclerView>(R.id.tasks_recycler)


        recyclerView?.layoutManager = this.layoutManager




        adapter = TaskAdapter(list , comm)



        recyclerView?.adapter = this.adapter

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }







}