package com.example.ucp2.ui.navigasi

interface AlamatNavigasi {
    val route: String
}

object DestinasiHome : AlamatNavigasi{
    override val route = "home"
}

object DestinasiDetail : AlamatNavigasi{
    override val route = "detail"
    const val ID_B = "id"
    val routesWithArgs = "$route/{$ID_B}"
}

