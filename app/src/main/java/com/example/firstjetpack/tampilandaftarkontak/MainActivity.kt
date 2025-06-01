package com.example.firstjetpack.tampilandaftarkontak

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
import com.example.firstjetpack.tampilandaftarkontak.ui.theme.FirstJetpackTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstJetpackTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        ContactList(navController)
                    }
                    composable(
                        route = "detail/{img}/{name}/{number}",
                        arguments = listOf(
                            navArgument("img") { type = NavType.IntType },
                            navArgument("name") { type = NavType.StringType },
                            navArgument("number") { type = NavType.StringType }
                        )//end arguments
                    )//end composable

                    { backStackEntry ->
                        val img = backStackEntry.arguments?.getInt("img")?: R.drawable.before
                        val name = backStackEntry.arguments?.getString("name") ?: "Default"
                        val number = backStackEntry.arguments?.getString("number") ?: "Default"
                        Detail(img, name, number)
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
                ContactList(navController)
            }
            composable(
                route = "detail/{img}/{name}/{number}",
                arguments = listOf(
                    navArgument("img") { type = NavType.IntType },
                    navArgument("name") { type = NavType.StringType },
                    navArgument("number") { type = NavType.StringType }
                )//end arguments
            )//end composable

            { backStackEntry ->
                val img = backStackEntry.arguments?.getInt("img")?: R.drawable.before
                val name = backStackEntry.arguments?.getString("name") ?: "Default"
                val number = backStackEntry.arguments?.getString("number") ?: "Default"
                Detail(img,  name, number)
            }
        }
    }
}