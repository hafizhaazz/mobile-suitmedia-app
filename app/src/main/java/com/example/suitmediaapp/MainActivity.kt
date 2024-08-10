package com.example.suitmediaapp

import ThirdPage
import UserService
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.suitmediaapp.ui.screens.FirstPage
import com.example.suitmediaapp.ui.screens.SecondPage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Create a NavController instance
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "first_screen") {
        composable("first_screen") {
            FirstPage(navController)
        }
        composable("second_screen/{selectedUserName}") { backStackEntry ->
            val selectedUserName = backStackEntry.arguments?.getString("selectedUserName") ?: ""
            SecondPage(selectedUserName, navController)
        }
        composable("third_screen") {
            val userService = UserService() // Replace with actual initialization
            ThirdPage(userService, navController)
        }
    }
}






