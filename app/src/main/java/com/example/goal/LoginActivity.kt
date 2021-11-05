package com.example.goal
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import com.example.goal.service.RestApiService

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val txtUsuario = findViewById<EditText>(R.id.txtUsuario);
        val txtSenha = findViewById<EditText>(R.id.txtSenha);

        val btnEntrar = findViewById<Button>(R.id.btnEntrar);

        btnEntrar.setOnClickListener {

            val apiService = RestApiService()

            val usuario = Usuario(
                email = txtUsuario.text.toString(),
                senha = txtSenha.text.toString())

            apiService.Login(usuario) {
                if (it != null) {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Falha no login", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}