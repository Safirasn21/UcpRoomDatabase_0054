package com.example.ucp2.ui.view.barang

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.ui.customwidget.TopAppBar
import com.example.ucp2.ui.navigasi.AlamatNavigasi
import com.example.ucp2.ui.viewmodel.barang.BarangEvent
import com.example.ucp2.ui.viewmodel.barang.BarangUIState
import com.example.ucp2.ui.viewmodel.barang.BrgViewModel
import com.example.ucp2.ui.viewmodel.barang.FormErrorState
import com.example.ucp2.ui.viewmodel.barang.PenyediaBrgViewModel
import kotlinx.coroutines.launch

object DestinasiInsert : AlamatNavigasi {
    override val route: String = "Insert_brg"
}

@Composable
fun InsertBrgView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BrgViewModel = viewModel(factory = PenyediaBrgViewModel.Factory)//Inisialisasi ViewModel
){
    val uiState = viewModel.uiState
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutlineScope = rememberCoroutineScope()

    //Observasi perubahan snackbarMessage
    LaunchedEffect(uiState.snackBarMesssage) {
        uiState.snackBarMesssage?.let {message ->
            coroutlineScope.launch {
                snackbarHostState.showSnackbar(message)
                viewModel.resetsnackBarMessage()
            }
        }

    }
    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
            padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            TopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Barang",
                modifier = modifier
            )
            //Isi Body
            InsertBodyBrg(
                uiState = uiState,
                onValueChange = {updatedEvent ->
                    viewModel.updateState(updatedEvent)
                },
                onClick = {
                    viewModel.saveData()
                    onNavigate()
                }
            )
        }
    }
}

@Composable
fun InsertBodyBrg(
    modifier: Modifier = Modifier,
    onValueChange: (BarangEvent) -> Unit,
    uiState: BarangUIState,
    onClick: () -> Unit
){
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        FormBarang(
            BarangEvent = uiState.BarangEvent,
            onValueChange = onValueChange,
            errorState = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Simpan")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FormBarang(
    BarangEvent: BarangEvent = BarangEvent(),
    onValueChange: (BarangEvent) -> Unit = {},
    errorState: FormErrorState = FormErrorState(),

    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = BarangEvent.name,
            onValueChange = {
                onValueChange(BarangEvent.copy(name = it))
            },
            label = { Text("Nama") },
            isError = errorState.name != null,
            placeholder = { Text("Masukkan nama") }
        )
        Text(
            text = errorState.name ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = BarangEvent.id_B,
            onValueChange = {
                onValueChange(BarangEvent.copy(id_B = it))
            },
            label = { Text("ID") },
            isError = errorState.id_B != null,
            placeholder = { Text("Masukkan ID Barang") }
        )
        Text(
            text = errorState.id_B ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = BarangEvent.desc,
            onValueChange = {
                onValueChange(BarangEvent.copy(desc = it))
            },
            label = { Text("Desc") },
            isError = errorState.desc != null,
            placeholder = { Text("Masukkan Deskripsi Barang") }
        )
        Text(
            text = errorState.desc ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = BarangEvent.price,
            onValueChange = {
                onValueChange(BarangEvent.copy(price = it))
            },
            label = { Text("Price") },
            isError = errorState.price != null,
            placeholder = { Text("Masukkan Harga Barang") }
        )
        Text(
            text = errorState.price ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = BarangEvent.stock,
            onValueChange = {
                onValueChange(BarangEvent.copy(stock = it))
            },
            label = { Text("Stock") },
            isError = errorState.stock != null,
            placeholder = { Text("Masukkan Stock Barang") }
        )
        Text(
            text = errorState.stock ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = BarangEvent.supname,
            onValueChange = {
                onValueChange(BarangEvent.copy(supname = it))
            },
            label = { Text("Suplier name") },
            isError = errorState.supname != null,
            placeholder = { Text("Masukkan Nama Suplier") }
        )
        Text(
            text = errorState.supname ?: "",
            color = Color.Red
        )
    }
}