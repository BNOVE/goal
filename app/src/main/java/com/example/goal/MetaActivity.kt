package com.example.goal
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.goal.model.Cofre
import com.example.goal.service.RestApiService
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

class MetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meta)
        supportActionBar?.hide()

        val apiService = RestApiService()
        val codigoCofre = intent.getIntExtra("codigoCofre", 0)

        val buttonSalvarMetaEditada = findViewById<Button>(R.id.buttonSalvarMetaEditada);
        val buttonExcluirMetaEditada = findViewById<Button>(R.id.buttonExcluirMetaEditada);

        if(codigoCofre == 0) {
            buttonExcluirMetaEditada.setVisibility(View.GONE)
        }
        val editMetaPercent = findViewById<TextView>(R.id.editMetaPercent)
        val editMetaIncentivo = findViewById<TextView>(R.id.editMetaIncentivo)
        val editNomeDaMeta = findViewById<EditText>(R.id.editNomeDaMeta)
        val editMetaInvestimento = findViewById<EditText>(R.id.editMetaInvestimento)
        val editPrazoMeta = findViewById<EditText>(R.id.editPrazoMeta)
        val editCategoria = findViewById<EditText>(R.id.editCategoria)
        val editAtualizarSaldo = findViewById<EditText>(R.id.editAtualizarSaldo)

        apiService.getPessoaConta(codigoPessoaSessao) {
            if (it != null) {

                val txtSaldoDisponivelParaMeta = findViewById<TextView>(R.id.txtSaldoDisponivelParaMeta);
                txtSaldoDisponivelParaMeta.setText("R$ " + it.saldoLivre.toString() + "0")
            }
        }

        if (codigoCofre != 0)
        {
            var dialog = Progress.progressDialog(this)
            dialog.show()

            apiService.getCofre(codigoPessoaSessao, codigoCofre) {
                if (it != null) {
                    editNomeDaMeta.setText(it.nome);
                    editMetaInvestimento.setText(it.valorMeta.toString());
                    editAtualizarSaldo.setText(it.valorTotal.toString());
                    val dataMetaR : List<String> =  it.vencimentoMeta.toString().split("-")
                    editPrazoMeta.setText(dataMetaR[2] + "/" + dataMetaR[1] + "/" + dataMetaR[0]);
                    editMetaPercent.setText( ((it.valorTotal/it.valorMeta)*100).roundToInt().toString() + "%");


                } else {
                    Toast.makeText(this, "Erro", Toast.LENGTH_LONG).show()
                }
                dialog.dismiss();
            }
        }

        buttonSalvarMetaEditada.setOnClickListener {
            var dialog = Progress.progressDialog(this)
            dialog.show()

            val dtAtual = LocalDate.now()
             //val stringDate = editPrazoMeta.text.toString()
           // val formatter = SimpleDateFormat("yyyy-MM-dd")

            if(editPrazoMeta.text.toString().equals(""))
                editPrazoMeta.setText("2025-01-01")
            val dataMeta : List<String> =  editPrazoMeta.text.toString().split("/")

            val cofre = Cofre(codigoCofre,
                editNomeDaMeta.text.toString(),
            "Descricao",
                dtAtual.toString(),
                dataMeta[2] + "-" + dataMeta[1] + "-" + dataMeta[0],
                editMetaInvestimento.text.toString().toDouble(),
                editAtualizarSaldo.text.toString().toDouble()
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
        val btnVoltarMain = findViewById<ImageView>(R.id.btnVoltarMain)
        btnVoltarMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}