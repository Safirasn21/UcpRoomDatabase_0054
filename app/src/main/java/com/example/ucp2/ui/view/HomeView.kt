package com.example.ucp2.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    onAddBarang: () -> Unit = {},
    onListBarang: () -> Unit ={},
    onAddSuplier: () -> Unit = {},
    onListSuplier: () -> Unit = {}
){
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment
            .CenterHorizontally
    ){
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onAddBarang
        ) {
            Text(text = "Tambah data barang")
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onListBarang
        ) {
            Text(text = "daftar barang")
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onAddSuplier
        ) {
            Text(text = "Tampah data suplier")
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onListSuplier
        ) {
            Text(text = "daftar supliet")
        }
    }
}