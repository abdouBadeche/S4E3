package com.example.mybib

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.livre_fragment.*
import kotlinx.android.synthetic.main.livre_item.*

class LivrePageFragment(var livre: Livre) : Fragment(R.layout.livre_fragment){



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initialisation
        tvName.text = livre.titre ;
        tvAuteur.text = livre.auteur ;
        tvresume.text = livre.resume ;


        val imageResource = resources.getIdentifier("@drawable/"+livre.photo, null, "com.example.mybib")
        val res = resources.getDrawable(imageResource) ;
        ivAuteur.setImageDrawable(res);




    }




    override fun onDestroyView() {
        super.onDestroyView()
    }





}