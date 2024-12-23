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



data class SuplierUIState(
    val SuplierEvent: SuplierEvent = SuplierEvent(),
    val isEntryValid: FormErrorStates = FormErrorStates(),
    val snackBarMesssage: String? = null
)

data class FormErrorStates(
    val idS: String? = null,
    val supname: String? = null,
    val contact: String? = null,
    val address: String? = null
){
    fun isValid(): Boolean{
        return idS == null && contact == null && address == null && supname == null
    }
}

fun SuplierEvent.toSuplierEntity(): Suplier= Suplier(
    id_S = id_S,
    supname = supname,
    contact = contact,
    address = address
)

data class SuplierEvent(
    val id_S: String = "",
    val supname: String = "",
    val contact: String = "",
    val address: String =" "
)