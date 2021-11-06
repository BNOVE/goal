package com.example.goal
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import com.example.goal.service.RestApiService

var codigoPessoaSessao : Int = 0
var usouPromocaoSessao : Boolean = false

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val txtUsuario = findViewById<EditText>(R.id.txtUsuario);
        val txtSenha = findViewById<EditText>(R.id.txtSenha);

        val btnEntrar = findViewById<Button>(R.id.btnEntrar);
        btnEntrar.setOnClickListener {
            var dialog = Progress.progressDialog(this)
            dialog.show()
            val apiService = RestApiService()

            val usuario = Usuario(
                email = txtUsuario.text.toString(),
                senha = txtSenha.text.toString())

            apiService.getLogin(usuario) {
                if (it != null) {
                    codigoPessoaSessao = it.codigo

                    apiService.getUsouPromocao(codigoPessoaSessao)
                    {
                        if (it != null) {
                            usouPromocaoSessao = it;
                        }
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }

                } else {
                    dialog.dismiss();
                    Toast.makeText(this, R.string.falhaLogin, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}