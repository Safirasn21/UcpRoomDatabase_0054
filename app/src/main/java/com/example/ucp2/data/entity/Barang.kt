package com.example.ucp2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class Barang(
    @PrimaryKey
    val id_B: String,
    val name: String,
    val desc: String,
    val price: String,
    val stock: String,
    val supname: String
)
