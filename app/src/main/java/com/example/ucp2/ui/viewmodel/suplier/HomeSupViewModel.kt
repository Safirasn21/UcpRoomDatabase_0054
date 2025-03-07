package com.example.ucp2.ui.viewmodel.suplier

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Suplier
import com.example.ucp2.repository.RepositoryS
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeSupViewModel (
    private val repositoryS: RepositoryS
) : ViewModel() {

    val homeUiStates: StateFlow<HomeUiStates> = repositoryS.getAllSuplier()
        .filterNotNull()
        .map {
            HomeUiStates (
                listSup = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(HomeUiStates(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                HomeUiStates(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiStates(
                isLoading = true,
            )
        )
}

data class HomeUiStates (
    val listSup: List<Suplier> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)