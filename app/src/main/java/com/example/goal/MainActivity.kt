package com.example.goal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.goal.controller.LoginController
import com.example.goal.controller.MainController
import com.example.goal.model.MetaItem
import com.example.goal.model.MetaItemAdapter
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = MainController()

        val listaMetas = findViewById<ListView>(R.id.listaMetas);

        var metaItemArray = ArrayList<MetaItem>()
        metaItemArray.add(MetaItem(1,"meta 1"))
        metaItemArray.add(MetaItem(2,"meta 2"))
        metaItemArray.add(MetaItem(3,"meta 3"))
        metaItemArray.add(MetaItem(4,"meta 4"))

        var adapter: MetaItemAdapter? = null
        adapter = MetaItemAdapter(this, metaItemArray );
        listaMetas.adapter = adapter;
        //val txtUsuario = findViewById<ListAdapter>(R.id.txtUsuario);
    }
}