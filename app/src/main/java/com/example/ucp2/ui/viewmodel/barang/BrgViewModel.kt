package com.example.ucp2.ui.viewmodel.barang

import com.example.ucp2.data.entity.Barang


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