package com.example.goal

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.goal.model.MetaItemAdapter
import com.example.goal.service.RestApiService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        if (usouPromocaoSessao) {
            var dialog = Progress.progressDialog(this)
            dialog.show()
            val apiService = RestApiService()
            apiService.getPessoaConta(codigoPessoaSessao) {
                if (it != null) {
                    val textViewSaldoMetaAqui = findViewById<TextView>(R.id.textViewSaldoMetaAqui);
                    textViewSaldoMetaAqui.setText("R$"+(it.saldoTotal - it.saldoLivre).toString() +"0")

                    val textViewSaldoDisponivelAqui = findViewById<TextView>(R.id.textViewSaldoDisponivelAqui);
                    textViewSaldoDisponivelAqui.setText(it.saldoLivre.toString())

                    val listaMetas = findViewById<ListView>(R.id.listaMetas);
                    var adapter: MetaItemAdapter? = null
                    adapter = MetaItemAdapter(this, it.cofre);
                    listaMetas.adapter = adapter
                }
                dialog.dismiss();
            }
            val btnNovaMeta = findViewById<Button>(R.id.btnNovaMeta);
            btnNovaMeta.setOnClickListener {
                val intent = Intent(this, MetaActivity::class.java)
                intent.putExtra("codigoCofre", 0)
                startActivity(intent)
            }
            val btnFecharMain = findViewById<ImageView>(R.id.btnFecharMain);
            btnFecharMain.setOnClickListener {
                codigoPessoaSessao=0
                usouPromocaoSessao=false
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        else{
            val intent = Intent(this, PromocaoActivity::class.java)
            startActivity(intent)
        }
    }
}