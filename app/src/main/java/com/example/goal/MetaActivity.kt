package com.example.goal
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.goal.model.Cofre
import com.example.goal.model.MetaItemAdapter
import com.example.goal.model.Usuario
import com.example.goal.service.RestApiService
import android.app.ProgressDialog





class MetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meta)

        val apiService = RestApiService()
        val codigoCofre = intent.getIntExtra("codigoCofre", 0)

        val buttonSalvarMetaEditada = findViewById<Button>(R.id.buttonSalvarMetaEditada);
        val buttonExcluirMetaEditada = findViewById<Button>(R.id.buttonExcluirMetaEditada);

        if(codigoCofre == 0) {
            buttonExcluirMetaEditada.setVisibility(View.GONE)
        }

        val textViewNomeMetaAqui = findViewById<TextView>(R.id.textViewNomeMetaAqui);
        if (codigoCofre != 0)
        {
            var dialog = Progress.progressDialog(this)
            dialog.show()
            apiService.getCofre(codigoPessoaSessao, codigoCofre) {
                if (it != null) {
                    textViewNomeMetaAqui.setText(it.nome);

                } else {
                    Toast.makeText(this, "Erro", Toast.LENGTH_LONG).show()
                }
                dialog.dismiss();
            }
        }

        buttonSalvarMetaEditada.setOnClickListener {
            var dialog = Progress.progressDialog(this)
            dialog.show()
            val cofre = Cofre(codigoCofre,
                "Nova meta",
            "Descricao da meta",
                "2021-11-06",
                "2025-11-06",
                150000.00,
                100.00
            )

            if(codigoCofre == 0){

                apiService.postCofre(codigoPessoaSessao, cofre) {
                    if (it != null) {
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        dialog.dismiss();
                        Toast.makeText(this, R.string.erroApi, Toast.LENGTH_LONG).show()
                    }
                }
            } else
            {
                var dialog = Progress.progressDialog(this)
                dialog.show()
                apiService.putCofre(codigoPessoaSessao, codigoCofre, cofre) {
                    if (it != null) {
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        dialog.dismiss();
                        Toast.makeText(this, R.string.erroApi, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        buttonExcluirMetaEditada.setOnClickListener {

            var dialog = Progress.progressDialog(this)
            dialog.show()
            apiService.deleteCofre(codigoPessoaSessao, codigoCofre){
                if (it != null) {
                    if(it) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else {
                        dialog.dismiss();
                        Toast.makeText(this,  R.string.erroApi, Toast.LENGTH_LONG).show()
                    }
                } else {
                    dialog.dismiss();
                    Toast.makeText(this,  R.string.erroApi, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}