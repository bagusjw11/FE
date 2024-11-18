package com.example.tugasfe.ui.theme

//import DetailGame
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugasfe.R
import com.example.tugasfe.model.FakeGameData
import com.example.tugasil.TugasFEApp
import com.example.tugasil.model.DetailGame
//import com.example.tugasil.model.DetailGame
//import com.example.tugasil.model.FakeGameData
import com.example.tugasil.navbar.BottomNavItem
import com.example.tugasil.navbar.Screen
import com.example.tugasil.pages.AboutPages
import com.example.tugasil.pages.GridPages
import com.example.tugasil.pages.ListPages
//import com.example.tugasil.ui.theme.TugasILTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TugasFEApp(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) {innerPadding ->
        NavHost(navController = navController as NavHostController, startDestination = Screen.List.route,
            modifier = Modifier.padding(innerPadding)) {
            composable(Screen.List.route){
                ListPages { game ->
                    navController.navigate("${Screen.Detail.route}/${game.id}")
                }

            }
            composable(Screen.Grid.route){
                GridPages{ game ->
                    navController.navigate("${Screen.Detail.route}/${game.id}")
                }
            }
            composable(Screen.About.route){
                AboutPages(modifier = Modifier)
            }
            composable("${Screen.Detail.route}/{gameId}") { backStackEntry ->
                val gameId = backStackEntry.arguments?.getString("gameId")
                val game = FakeGameData.dummyGames.firstOrNull { it.id == gameId }
                if (game != null) {
                    DetailGame(game = game, navController)
                } else {
                    Text("Game not found!")
                }
            }



        }

    }
}

@Composable
private fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier){
    NavigationBar(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            BottomNavItem(
                title = stringResource(id = R.string.app_name),
                icon = Icons.Default.List,
                screen = Screen.List
            ),
            BottomNavItem(
                title = stringResource(id = R.string.app_name),
                icon = Icons.Default.Menu,
                screen = Screen.Grid
            ),
            BottomNavItem(
                title = stringResource(id = R.string.app_name),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                label = { Text(item.title) },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TugasILAppPreview() {
    TugasFEApp()
        TugasFEApp()
    }
