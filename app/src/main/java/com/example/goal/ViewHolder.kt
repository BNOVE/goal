package com.example.goal

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val lnlItemMeta = view.findViewById<LinearLayout>(R.id.lnlItemMeta)
    val imgItemMeta = view.findViewById<ImageView>(R.id.imgItemMeta)
    val txtItemMeta = view.findViewById<TextView>(R.id.txtItemMeta)
    val txtDataVencimentoMeta = view.findViewById<TextView>(R.id.txtDataVencimentoMeta)
    val txtLucro = view.findViewById<TextView>(R.id.txtLucro)
    val txtValorTotal = view.findViewById<TextView>(R.id.txtValorTotal)
}