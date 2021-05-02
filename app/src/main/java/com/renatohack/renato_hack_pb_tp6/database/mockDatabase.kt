package com.renatohack.renato_hack_pb_tp6.database

object mockDatabase {

    var liquido = ""
    var totalDescontos = ""
    var porcentagem = ""

    fun mudarDados(liquidoParam : String, totalDescontosParam: String, porcentagemParam: String){
        liquido = liquidoParam
        totalDescontos = totalDescontosParam
        porcentagem = "${porcentagemParam}%"
    }

}