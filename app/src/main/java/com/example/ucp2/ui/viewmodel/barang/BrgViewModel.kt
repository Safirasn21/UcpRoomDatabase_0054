package com.example.ucp2.ui.viewmodel.barang

import com.example.ucp2.data.entity.Barang

data class FormErrorState(
    val id_B: String? = null,
    val name: String? = null,
    val desc: String? = null,
    val price: String? = null,
    val stock: String? = null,
    val supname: String? = null
){
    fun isValid(): Boolean{
        return id_B == null && name == null && desc == null && price == null
                && stock == null && supname == null
    }
}

fun BarangEvent.toBarangEntity(): Barang = Barang(
    id_B = id_B,
    name = name,
    desc = desc,
    price = price,
    stock = stock,
    supname = supname
)

data class BarangEvent(
    val id_B: String =" ",
    val name: String = "",
    val desc: String = "",
    val price: String = "",
    val stock: String = "",
    val supname: String =""
)