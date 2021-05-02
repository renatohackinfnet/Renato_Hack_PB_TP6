package com.renatohack.renato_hack_pb_tp6.telaSecundaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.renatohack.renato_hack_pb_tp6.R
import com.renatohack.renato_hack_pb_tp6.database.mockDatabase
import kotlinx.android.synthetic.main.activity_tela_resultados.*

class TelaResultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultados)

        exibirResultado()
    }

    fun exibirResultado(){
        textViewResultadoSalarioLiquido.text = mockDatabase.liquido
        textViewResultadoDescontos.text = mockDatabase.totalDescontos
        textViewResultadoPorcentagem.text = mockDatabase.porcentagem
    }
}