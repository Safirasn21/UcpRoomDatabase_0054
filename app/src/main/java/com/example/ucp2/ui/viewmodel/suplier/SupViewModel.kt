package com.example.ucp2.ui.viewmodel.suplier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Suplier
import com.example.ucp2.repository.LocalRepositoryS
import kotlinx.coroutines.launch

class SupViewModel(private val repositoryS: LocalRepositoryS) : ViewModel(){
    var uiState by mutableStateOf(SuplierUIState())
    fun updateState(SuplierEvent: SuplierEvent){
        uiState = uiState.copy(
            SuplierEvent = SuplierEvent,
        )
    }

    private fun validateFields(): Boolean{
        val event = uiState.SuplierEvent
        val errorState = FormErrorStates(
            idS = if (event.id_S.isNotEmpty()) null else "Suplier Id tidak boleh kosong!",
            supname = if (event.supname.isNotEmpty()) null else "Suplier Name tidak boleh kosong!",
            contact = if (event.contact.isNotEmpty()) null else "Suplier contact tidak boleh kosong!",
            address = if (event.address.isNotEmpty()) null else "Suplier address tidak boleh kosong!"
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData(){
        val currentEvent = uiState.SuplierEvent

        if (validateFields()){
            viewModelScope.launch {
                try{
                    repositoryS.insertSuplier(currentEvent.toSuplierEntity())
                    uiState = uiState.copy(
                        snackBarMesssage = "Data berhasil disimpan",
                        SuplierEvent  = SuplierEvent(),
                        isEntryValid  = FormErrorStates()
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