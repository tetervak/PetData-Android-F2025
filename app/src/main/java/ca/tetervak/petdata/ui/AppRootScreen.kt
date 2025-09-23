package ca.tetervak.petdata.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ca.tetervak.petdata.ui.petdetails.PetDetailsScreen
import ca.tetervak.petdata.ui.petlist.PetListScreen

@Composable
fun AppRootScreen() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "pet-list"
    ) {
        composable(route = "pet-list") {
            PetListScreen(
                onItemClick = { navController.navigate("pet-details/$it") }
            )
        }
        composable(
            route = "pet-details/{petId}",
            arguments = listOf(navArgument("petId") { type = NavType.IntType })
        ) {
            PetDetailsScreen(
                onNavigateBack = { navController.navigateUp() }
            )
        }
    }
}