package com.example.ucp2.ui.viewmodel.barang

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.repository.RepositoryB
import com.example.ucp2.ui.navigasi.DestinasiDetail
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DetailBrgViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryB: RepositoryB,
) : ViewModel(){
    private val _id_B: String = checkNotNull(savedStateHandle[DestinasiDetail.ID_B])

    val detailUIState: StateFlow<DetailUiState> = repositoryB.getBarang(_id_B)
        .filterNotNull()
        .map {
            DetailUiState(
                detailUiEvent = it.toDetailUiEvent(),
                isLoading = false,
            )
        }
        .onStart {
            emit(DetailUiState(isLoading = true))
            delay(600)
        }
        .catch {
            emit(
                DetailUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi kesalahan",
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(2000),
            initialValue = DetailUiState(
                isLoading = true,
            ),
        )
    fun deleteBrg(){
        detailUIState.value.detailUiEvent.toBarangEntity().let{
            viewModelScope.launch {
                repositoryB.deleteBarang(it)
            }
        }
    }
}

data class DetailUiState(
    val detailUiEvent: BarangEvent = BarangEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == BarangEvent()
    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != BarangEvent()
}

fun Barang.toDetailUiEvent(): BarangEvent{
    return BarangEvent(
        id_B = id_B,
        name = name,
        desc = desc,
        price = price,
        stock = stock,
        supname = supname
    )
}