package com.example.ucp2.ui.viewmodel.barang

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.data.repository.LocalRepositoryB
import kotlinx.coroutines.launch

class BrgViewModel(private val repositoryBrg: LocalRepositoryB) : ViewModel(){
    var uiState by mutableStateOf(BarangUIState())
    fun updateState(BarangEvent: BarangEvent){
        uiState = uiState.copy(
            BarangEvent = BarangEvent,
        )
    }

    private fun validateFields(): Boolean{
        val event = uiState.BarangEvent
        val errorState = FormErrorState(
            id_B = if (event.id_B.isNotEmpty()) null else "Id Barang tidak boleh kosong!",
            name = if (event.name.isNotEmpty()) null else "Nama Barang tidak boleh kosong!",
            desc = if (event.desc.isNotEmpty()) null else "Description tidak boleh kosong!",
            price = if (event.price.isNotEmpty()) null else "Harga Barang tidak boleh kosong!",
            stock = if (event.stock.isNotEmpty()) null else "Stock Barang tidak boleh kosong!",
            supname = if (event.supname.isNotEmpty()) null else "Suplier Name tidak boleh kosong!"
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData(){
        val currentEvent = uiState.BarangEvent

        if (validateFields()){
            viewModelScope.launch {
                try{
                    repositoryBrg.insertBarang(currentEvent.toBarangEntity())
                    uiState = uiState.copy(
                        snackBarMesssage = "Data berhasil disimpan",
                        BarangEvent = BarangEvent(),
                        isEntryValid  = FormErrorState()
                    )
                } catch (e: Exception){
                    uiState = uiState.copy(
                        snackBarMesssage = "Data gagal disimpan"
                    )
                }
            }
        }
        else {
            uiState = uiState.copy(
                snackBarMesssage = "Input tidak valid. periksa kembali data anda"
            )
        }
    }
    fun resetsnackBarMessage(){
        uiState = uiState.copy(snackBarMesssage = null)
    }
}

data class BarangUIState(
    val BarangEvent: BarangEvent = BarangEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMesssage: String? = null
)

data class FormErrorState(
    val id_B: String? = null,
    val name: String? = null,
    val desc: String? = null,
    val price: String? = null,
    val stock: String? = null,
    val supname: String? = null
){
    fun isValid(): Boolean{
        return id_B == null && name == null && desc == null && price == null
                && stock == null && supname == null
    }
}

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