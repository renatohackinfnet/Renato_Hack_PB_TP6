package com.renatohack.renato_hack_pb_tp6.telaPrincipal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.renatohack.renato_hack_pb_tp6.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PrincipalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view : Button = findViewById(R.id.buttonCalcular)

        viewModel = ViewModelProvider(this).get(PrincipalViewModel::class.java)

        buttonCalcular.setOnClickListener {

            if (editTextsalarioBrutoPrincipal.text.toString() != "") {
                textView.text = calcularLiquido()
            }
            else {
                Snackbar.make(this,
                        view,
                        "Você precisa preencher o campo \"Salário Bruto\".",
                        Snackbar.LENGTH_LONG).show()
            }
        }
    }


    private fun calcularLiquido() : String{

        val bruto = editTextsalarioBrutoPrincipal.text.toString()
        val dependentes = editTextnoDependentesPrincipal.text.toString()
        val pensao = editTextpensaoPrincipal.text.toString()
        val plano = editTextplanoPrincipal.text.toString()
        val descontos = editTextdescontosPrincipal.text.toString()

        val liquido = viewModel.calcularSalarioLiquido(bruto, dependentes, pensao, plano, descontos)

        return liquido
    }

}