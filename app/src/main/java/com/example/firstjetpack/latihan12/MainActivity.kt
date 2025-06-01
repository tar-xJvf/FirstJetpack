package com.example.firstjetpack.latihan12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstjetpack.R
import com.example.firstjetpack.latihan12.ui.theme.FirstJetpackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstJetpackTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        MasterBarang(navController)
                    }
                    composable(
                        route = "detail/{img}/{name}/{price}/{desc}",
                        arguments = listOf(
                            navArgument("img") { type = NavType.IntType },
                            navArgument("name") { type = NavType.StringType },
                            navArgument("price") { type = NavType.StringType },
                            navArgument("desc") { type = NavType.StringType },
                        )//end arguments
                    )//end composable

                    { backStackEntry ->
                        val img = backStackEntry.arguments?.getInt("img") ?: R.drawable.before
                        val name = backStackEntry.arguments?.getString("name") ?: "Default"
                        val price = backStackEntry.arguments?.getString("price") ?: "Default"
                        val desc = backStackEntry.arguments?.getString("desc") ?: "Default"
                        DetailProduct(img, name, price, desc)
                    }
                }
            } // end theme
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstJetpackTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
               MasterBarang(navController)
            }
            composable(
                route = "detail/{img}/{name}/{price}/{desc}",
                arguments = listOf(
                    navArgument("img") { type = NavType.IntType },
                    navArgument("name") { type = NavType.StringType },
                    navArgument("price") { type = NavType.StringType },
                    navArgument("desc") { type = NavType.StringType },
                )//end arguments
            )//end composable

            { backStackEntry ->
                val img = backStackEntry.arguments?.getInt("img") ?: R.drawable.before
                val name = backStackEntry.arguments?.getString("name") ?: "Default"
                val price = backStackEntry.arguments?.getString("price") ?: "Default"
                val desc = backStackEntry.arguments?.getString("desc") ?: "Default"
                DetailProduct(img, name, price, desc)
            }
        }
    }
}