package com.example.ucp2.ui.viewmodel.barang

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.repository.RepositoryB
import com.example.ucp2.ui.navigasi.DestinasiUpdate
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateBrgViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryB: RepositoryB
) : ViewModel(){
    var updateUIState by mutableStateOf(BarangUIState())
        private set

    private  val _Id_B: String = checkNotNull(savedStateHandle[DestinasiUpdate.ID_B])
    init {
        viewModelScope.launch {
            updateUIState = repositoryB.getBarang(_Id_B)
                .filterNotNull()
                .first()
                .toUIStateBrg()
        }
    }

    fun updateState(barangEvent: BarangEvent){
        updateUIState = updateUIState.copy(
            BarangEvent = barangEvent,
        )
    }

    fun validateFields(): Boolean{
        val event = updateUIState.BarangEvent
        val errorState = FormErrorState(
            id_B = if (event.id_B.isNotEmpty()) null else "Id barang tidak boleh kosong",
            name = if (event.name.isNotEmpty()) null else "Nama barang tidak boleh kosong",
            desc = if (event.desc.isNotEmpty()) null else "Deskripsi barang tidak boleh kosong",
            price = if (event.price.isNotEmpty()) null else "Harga tidak boleh kosong",
            stock = if (event.stock.isNotEmpty()) null else "Stok barang tidak boleh kosong",
            supname = if (event.supname.isNotEmpty()) null else "Nama suplier tidak boleh kosong"
        )
        updateUIState = updateUIState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun updateData(){
        val currentEvent = updateUIState.BarangEvent

        if (validateFields()){
            viewModelScope.launch {
                try {
                    repositoryB.updateBarang(currentEvent.toBarangEntity())
                    updateUIState = updateUIState.copy(
                        snackBarMesssage = "Data berhasil diupdate",
                        BarangEvent = BarangEvent(),
                        isEntryValid = FormErrorState()
                    )
                    println("snackBarMessage diatur: ${updateUIState.
                    snackBarMesssage}")
                } catch (e: Exception){
                    updateUIState = updateUIState.copy(
                        snackBarMesssage = "Data gagal diupdate"
                    )
                }
            }
        } else {
            updateUIState = updateUIState.copy(
                snackBarMesssage = "Data gagal diupdate"
            )
        }
    }
    fun resetSnackBarMessage(){
        updateUIState = updateUIState.copy(snackBarMesssage = null)
    }
}

fun  Barang.toUIStateBrg(): BarangUIState = BarangUIState(
    BarangEvent =  this.toDetailUiEvent(),
)