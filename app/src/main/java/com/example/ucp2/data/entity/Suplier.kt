package com.example.ucp2.data.entity

import androidx.room.DatabaseView
import androidx.room.Entity
import androidx.room.PrimaryKey

@DatabaseView
@Entity(tableName = "suplier")
data class Suplier(
    @PrimaryKey
    val id_S: String,
    val supname: String,
    val contact: String,
    val address: String
)
