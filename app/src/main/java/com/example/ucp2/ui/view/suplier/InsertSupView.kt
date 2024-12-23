package com.example.ucp2.ui.view.suplier

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
import com.example.ucp2.ui.viewmodel.barang.FormErrorState
import com.example.ucp2.ui.viewmodel.suplier.FormErrorStates
import com.example.ucp2.ui.viewmodel.suplier.PenyediaSupViewModel
import com.example.ucp2.ui.viewmodel.suplier.SupViewModel
import com.example.ucp2.ui.viewmodel.suplier.SuplierEvent
import com.example.ucp2.ui.viewmodel.suplier.SuplierUIState
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun FormSuplier(
    SuplierEvent: SuplierEvent = SuplierEvent(),
    onValueChange: (SuplierEvent) -> Unit = {},
    errorStates: FormErrorStates = FormErrorStates(),
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = SuplierEvent.id_S,
            onValueChange = {
                onValueChange(SuplierEvent.copy(id_S = it))
            },
            label = { Text("ID") },
            isError = errorStates.idS != null,
            placeholder = { Text("Masukkan nama") }
        )
        Text(
            text = errorStates.idS ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = SuplierEvent.supname,
            onValueChange = {
                onValueChange(SuplierEvent.copy(supname = it))
            },
            label = { Text("ID") },
            isError = errorStates.supname != null,
            placeholder = { Text("Masukkan ID Suplier") }
        )
        Text(
            text = errorStates.supname ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = SuplierEvent.contact,
            onValueChange = {
                onValueChange(SuplierEvent.copy(contact = it))
            },
            label = { Text("Contact") },
            isError = errorStates.address != null,
            placeholder = { Text("Masukkan Contact suplier") }
        )
        Text(
            text = errorStates.contact ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = SuplierEvent.address,
            onValueChange = {
                onValueChange(SuplierEvent.copy(address = it))
            },
            label = { Text("Address") },
            isError = errorStates.address != null,
            placeholder = { Text("Masukkan address suplier") }
        )
        Text(
            text = errorStates.address ?: "",
            color = Color.Red
        )
    }

}