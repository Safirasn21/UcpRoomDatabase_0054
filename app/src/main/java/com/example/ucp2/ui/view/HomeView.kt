package com.example.ucp2.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ucp2.R

@Composable
fun SectionHeader() {
    Box(
        modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Blue))
    Row {
        Box(contentAlignment = Alignment.BottomEnd){
            Image(painter = painterResource(id = R.drawable.img), contentDescription = " ",
                Modifier
                    .size(80.dp)
                    .clip(shape = CircleShape)
            )
        }
        Column (Modifier.padding(15.dp)){
            Text(text = "Halo!", color = Color.White)
            Text(text = "Safira", color = Color.White)
        }
    }
}
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