package com.example.ucp2.ui.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2.ui.view.barang.DestinasiInsert
import com.example.ucp2.ui.view.barang.DetailBrgView
import com.example.ucp2.ui.view.barang.HomeBrgView
import com.example.ucp2.ui.view.barang.InsertBrgView
import com.example.ucp2.ui.view.barang.UpdateBrgView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiInsert.route) {
        composable(
            route = DestinasiInsert.route

        ) {
            HomeBrgView(
                onDetailClick = { id_B ->
                    navController.navigate("${DestinasiDetail.route}/$id_B")
                    println(
                        "PengelolaHalaman: id_B = $id_B"
                    )
                },
                onAddBrg = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsert.route

        ) {
            InsertBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = { navController.popBackStack()
                },
                modifier = modifier
            )
        }

        composable(
            DestinasiDetail.routesWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetail.ID_B){
                    type = NavType.StringType
                }
            )
        ) {
            val id_B = it.arguments?.getString(DestinasiDetail.ID_B)
            id_B?.let { id_B ->
                DetailBrgView(
                    onBack =  {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(
            DestinasiUpdate.routesWithArgs,
            arguments = listOf(
                navArgument(DestinasiUpdate.ID_B){
                    type = NavType.StringType
                }
            )
        ){
            UpdateBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier,
            )
        }
    }
}