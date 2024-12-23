package com.example.ucp2.data

data class Supplier(val id: String, val name: String)

object SuplierList {

    val suppliers = listOf(
        Supplier("1", "Supplier Ulfa"),
        Supplier("2", "Supplier Iffa"),
        Supplier("3", "Supplier Namira"),
        Supplier("4", "Supplier Rara")
    )

    fun getAllSuppliers(): List<Supplier> {
        return suppliers
    }
}
