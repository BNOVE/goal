package com.example.goal
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.goal.service.RestApiService
import kotlinx.android.synthetic.main.activity_promocao.*
class PromocaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promocao)


        val btnUsarPromocao = findViewById<Button>(R.id.btnUsarPromocao);
        btnUsarPromocao.setOnClickListener {
            var dialog = Progress.progressDialog(this)
            dialog.show()

            val apiService = RestApiService()

            apiService.getPessoaConta(codigoPessoaSessao) {
                if (it != null) {
                    apiService.postPromocao(codigoPessoaSessao, it.codigo, 100.00)
                    {
                        if (it != null && it) {
                            usouPromocaoSessao = true;
                            val intent = Intent(this, MetaActivity::class.java)
                            intent.putExtra("codigoCofre", 0)
                            startActivity(intent)
                        } else {
                            dialog.dismiss();
                            Toast.makeText(this, R.string.erroApi, Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    dialog.dismiss();
                    Toast.makeText(this, R.string.erroApi, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}