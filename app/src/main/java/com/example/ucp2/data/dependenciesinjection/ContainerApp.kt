package com.example.ucp2.data.dependenciesinjection

import android.content.Context
import com.example.ucp2.data.database.TokoDatabase
import com.example.ucp2.data.repository.LocalRepositoryB
import com.example.ucp2.data.repository.LocalRepositoryS
import com.example.ucp2.data.repository.RepositoryB
import com.example.ucp2.data.repository.RepositoryS

interface InterfaceContainerApp {
    val repositoryB: RepositoryB
    val repositoryS: RepositoryS
}

class ContainerApp(private val context: Context): InterfaceContainerApp{
    override val repositoryB: RepositoryB by lazy {
        LocalRepositoryB(TokoDatabase.getDatabase(context).barangDao())
    }
    override val repositoryS: RepositoryS by lazy {
        LocalRepositoryS(TokoDatabase.getDatabase(context).suplierDao())
    }

}