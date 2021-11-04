package com.example.goal
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.goal.controller.LoginController
import com.example.goal.model.Pessoa

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val controller = LoginController()
        val txtUsuario = findViewById<EditText>(R.id.txtUsuario);
        val txtSenha = findViewById<EditText>(R.id.txtSenha);

        val btnEntrar = findViewById<Button>(R.id.btnEntrar);

        btnEntrar.setOnClickListener {

            val pessoa: Pessoa? =  controller.Logar(txtUsuario.text.toString(), txtSenha.text.toString())
            if(pessoa != null){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else {

                Toast.makeText(this, "Falha no login", Toast.LENGTH_LONG).show()
            }

        }

    }
}