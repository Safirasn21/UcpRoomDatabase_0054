package com.example.ucp2.ui.viewmodel.barang

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.TokoApp

object PenyediaBrgViewModel{
    val Factory = viewModelFactory {
        initializer {
            BrgViewModel(
                TokoApp().containerApp.repositoryB

            )
        }
        initializer {
            HomeBrgViewModel(
                TokoApp().containerApp.repositoryB
            )
        }
        initializer {
            DetailBrgViewModel(
                createSavedStateHandle(),
                TokoApp().containerApp.repositoryB,
            )
        }
        initializer {
            UpdateBrgViewModel(
                createSavedStateHandle(),
                TokoApp().containerApp.repositoryB,
            )
        }
    }
}
fun CreationExtras.TokoApp(): TokoApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TokoApp)