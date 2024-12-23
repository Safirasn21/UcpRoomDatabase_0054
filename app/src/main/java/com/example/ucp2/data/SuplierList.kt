package com.example.ucp2.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.ui.viewmodel.suplier.HomeSupViewModel
import com.example.ucp2.ui.viewmodel.suplier.PenyediaSupViewModel

//data class Supplier(val id: String, val name: String)
//
//object SuplierList {
//
//    val suppliers = listOf(
//        Supplier("1", "Supplier Ulfa"),
//        Supplier("2", "Supplier Iffa"),
//        Supplier("3", "Supplier Namira"),
//        Supplier("4", "Supplier Rara")
//    )
//
//    fun getAllSuppliers(): List<Supplier> {
//        return suppliers
//    }
//}

object SuplierList {
    @Composable
    fun Supname(
        SupViewModel : HomeSupViewModel = viewModel(factory = PenyediaSupViewModel.Factory)
    ): List<String>{
        val suplname = SupViewModel.homeUiStates.collectAsState()
        val suplist = suplname.value.listSup
        return suplist.map {it.supname}
    }
}
