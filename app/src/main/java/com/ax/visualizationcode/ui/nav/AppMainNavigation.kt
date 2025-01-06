package com.ax.visualizationcode.ui.nav


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ax.visualizationcode.ui.page.home.HomePage
import com.ax.visualizationcode.ui.page.visualization.VisualizationPage

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomePage()
//            HomeScreen {
//                navController.navigate("detail")
//            }
        }
//        composable("detail") {
//            DetailScreen()
//        }
    }
}