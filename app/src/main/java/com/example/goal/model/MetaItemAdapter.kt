package com.example.goal.model

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goal.MainActivity
import com.example.goal.MetaActivity
import com.example.goal.R
import com.example.goal.ViewHolder



class MetaItemAdapter(private val context: Context, private val arrayList: List<Cofre>) : BaseAdapter() {

    private val transacoes = arrayList

    private lateinit var  lnlItemMeta : LinearLayout
    private lateinit var  imgItemMeta   : ImageView
    private lateinit var  txtItemMeta  : TextView
    private lateinit var  txtDataVencimentoMeta  : TextView
    private lateinit var  txtLucro  : TextView
    private lateinit var  txtValorTotal : TextView
    override fun getCount(): Int {
        return arrayList.size
    }
    override fun getItem(position: Int): Any {
        return arrayList[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.item_meta, parent, false)
        lnlItemMeta = convertView.findViewById<LinearLayout>(R.id.lnlItemMeta)
        imgItemMeta = convertView.findViewById<ImageView>(R.id.imgItemMeta)
        txtItemMeta = convertView.findViewById<TextView>(R.id.txtItemMeta)
        txtLucro = convertView.findViewById<TextView>(R.id.txtLucro)
        txtDataVencimentoMeta = convertView.findViewById<TextView>(R.id.txtDataVencimentoMeta)
        txtValorTotal = convertView.findViewById<TextView>(R.id.txtValorTotal)

        txtItemMeta.setText(arrayList[position].nome);
        txtDataVencimentoMeta.setText(arrayList[position].vencimentoMeta);
        txtValorTotal.setText(arrayList[position].valorTotal.toString());

        convertView.setOnClickListener{

            val id : Int =  arrayList[position].codigo
            val intent = Intent(context,MetaActivity::class.java)
            intent.putExtra("codigoCofre", arrayList[position].codigo)
            context.startActivity(intent)
        }

        return convertView
    }
}


