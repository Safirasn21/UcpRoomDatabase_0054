package com.example.ucp2.ui.viewmodel.suplier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Suplier
import com.example.ucp2.data.repository.LocalRepositoryS
import com.example.ucp2.ui.viewmodel.barang.FormErrorState
import kotlinx.coroutines.launch



data class SuplierEvent(
    val id_S: String = "",
    val supname: String = "",
    val contact: String = "",
    val address: String =" "
)