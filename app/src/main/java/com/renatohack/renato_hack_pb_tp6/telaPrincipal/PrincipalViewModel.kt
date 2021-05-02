package com.renatohack.renato_hack_pb_tp6.telaPrincipal

import androidx.lifecycle.ViewModel

class PrincipalViewModel : ViewModel() {

    fun calcularSalarioLiquido(bruto: String,
                                       dependentes: String?,
                                       pensao: String?,
                                       plano: String?,
                                       descontos: String?) : String {

        val brutoF = toFloat(bruto)
        val dependentesF = toFloat(dependentes)
        val pensaoF = toFloat(pensao)
        val planoF = toFloat(plano)
        val descontosF = toFloat(descontos)

        val liquido = brutoF - INSS(brutoF) - IRPF(brutoF) - pensaoF - planoF - descontosF - dependentesF*189.59f

        return liquido.toString()
    }

    private fun toFloat(myString: String?) : Float{
        if (myString != null && myString != ""){
            return myString.toFloat()
        }
        else return 0.0f
    }

    private fun INSS(bruto: Float) : Float {

        if (bruto <= 1659.38f){
            return bruto*0.08f
        }
        else if(bruto > 1659.38f && bruto <= 2765.66f){
            return bruto*0.09f
        }
        else if(bruto > 2765.66f && bruto <= 5531.31f){
            return bruto*0.11f
        }
        else{
            return 608.44f
        }
    }

    private fun IRPF (bruto: Float) : Float{

        if (bruto <= 1903.98f){
            return 0f
        }
        else if(bruto > 1903.98f && bruto <= 2826.65f){
            return bruto*0.075f
        }
        else if(bruto > 2826.65f && bruto <= 3751.05f){
            return bruto*0.15f
        }
        else if(bruto > 3751.05f && bruto <= 4664.68f){
            return bruto*0.225f
        }
        else{
            return bruto*0.275f
        }

    }
}
