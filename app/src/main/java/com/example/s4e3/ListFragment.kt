package com.example.mybib

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment (var list: List<Livre>) : Fragment(R.layout.recycler_livre_fragment){


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<LivreAdapter.ViewHolder>? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(requireContext())


        val recyclerView = view?.findViewById<RecyclerView>(R.id.livre_recycler)


        recyclerView?.layoutManager = this.layoutManager




        adapter = LivreAdapter(list)



        recyclerView?.adapter = this.adapter

    }







}