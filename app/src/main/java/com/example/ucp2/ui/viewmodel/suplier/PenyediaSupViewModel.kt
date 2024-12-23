package com.example.ucp2.ui.viewmodel.suplier

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.TokoApp
import com.example.ucp2.repository.LocalRepositoryS


object PenyediaSupViewModel{
    val Factory = viewModelFactory {
        initializer {
            SupViewModel(
                TokoApp().containerApp.repositoryS as LocalRepositoryS

            )
        }
        initializer {
            HomeSupViewModel(
                TokoApp().containerApp.repositoryS
            )
        }
    }
}
fun CreationExtras.TokoApp(): TokoApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TokoApp)