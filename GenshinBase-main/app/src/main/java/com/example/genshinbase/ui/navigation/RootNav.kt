package com.example.genshinbase.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.genshinbase.ui.presentation.detailCharacter.DetailCharacterScreen
import com.example.genshinbase.ui.presentation.detailMaterial.DetailMaterialScreen
import com.example.genshinbase.ui.presentation.home.HomeScreen
import com.example.genshinbase.ui.presentation.main.MainScreen
import com.example.genshinbase.ui.presentation.material.MaterialScreen
import com.example.genshinbase.ui.presentation.weapon.WeaponCharacterScreen


//данные о экранах навигации
sealed class Screens(val route: String, val title: String = "", val icon: ImageVector? = null) {

    object Main : Screens(route = "main", title = "Персонажи", icon = Icons.Default.Person)
    object Weapon : Screens(route = "weapon", title = "Оружие", icon = Icons.Default.Build)
    object Home : Screens(route = "home", title = "Главная", icon = Icons.Default.Home)
    object Material :
        Screens(route = "material", title = "Материалы", icon = Icons.AutoMirrored.Default.List)

    object MaterialDetail : Screens(route = "material/{id}"){
        fun generateLink(id: Long): String {
            return "material/$id"
        }
    }

    object DetailCharacter : Screens(route = "character/{id}") {
        fun generateLink(id: Long): String {
            return "character/$id"
        }
    }

}

val items = listOf(Screens.Home, Screens.Main, Screens.Weapon, Screens.Material)

@Composable
fun RootNav(navController: NavHostController) {
    val viewModel = hiltViewModel<RootNavViewModel>()
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.checkData()
    }

    if (state.loadData) {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier,
                    backgroundColor = MaterialTheme.colorScheme.inverseOnSurface
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        val selected =
                            currentDestination?.hierarchy?.any { it.route == screen.route } == true
                        screen.icon?.let {
                            BottomNavigationItem(
                                modifier = Modifier.padding(vertical = 10.dp),
                                icon = {
                                    Icon(
                                        screen.icon,
                                        contentDescription = null,
                                        modifier = Modifier.size(if (selected) 32.dp else 24.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        modifier = Modifier.padding(top = 5.dp),
                                        text = screen.title,
                                        style = if (selected) MaterialTheme.typography.titleMedium else MaterialTheme.typography.titleSmall,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                },
                                selected = selected,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Screens.Main.route,
                modifier = Modifier.padding(padding)
            ) {
                composable(
                    route = Screens.MaterialDetail.route,
                    arguments = listOf(navArgument("id") {
                        type = NavType.LongType
                    })
                ) {
                    val id = it.arguments?.getLong("id")
                    println("id $id")
                    DetailMaterialScreen(
                        navHostController = navController,
                        materialId = id ?: 0
                    )
                }
                composable(route = Screens.Main.route) {
                    MainScreen(navHostController = navController)
                }
                composable(route = Screens.Material.route) {
                    MaterialScreen(navHostController = navController)
                }

                composable(route = Screens.Weapon.route) {
                    WeaponCharacterScreen(navHostController = navController)
                }

                composable(route = Screens.Home.route) {
                    HomeScreen(navController)
                }

                composable(
                    route = Screens.DetailCharacter.route,
                    arguments = listOf(navArgument("id") {
                        type = NavType.LongType
                    })
                ) {
                    val id = it.arguments?.getLong("id")
                    println("id $id")
                    DetailCharacterScreen(
                        navHostController = navController,
                        characterId = id ?: 0
                    )
                }
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(modifier = Modifier.size(60.dp))
        }
    }
}