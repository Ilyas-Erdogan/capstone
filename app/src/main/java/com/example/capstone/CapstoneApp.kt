package com.example.capstone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstone.ui.Stats.StatsScreen
import com.example.capstone.ui.navigation.CapstoneNavigationBar

@Composable
fun CapstoneApp(
    appState: CapstoneAppState = rememberAppState()
) {
    Scaffold(
        bottomBar = { CapstoneNavigationBar(navigateTo = { appState.navigate(it) }) }
    ) { innerPaddingModifier ->

        NavHost(
            navController = appState.navController,
            startDestination = NavigationItem.StatsScreen.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddingModifier)
        ) {
            reportGraph(appState = appState)
            statsGraph(appState = appState)
            profileGraph(appState = appState)
        }
    }
}

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    CapstoneAppState(navController = navController)
}

fun NavGraphBuilder.reportGraph(appState: CapstoneAppState) {
    composable(route = NavigationItem.ReportScreen.route) {
        Column {
            Text(text = "Report")
        }
    }
}

fun NavGraphBuilder.statsGraph(appState: CapstoneAppState) {
    composable(route = NavigationItem.StatsScreen.route) {
        Column {
            StatsScreen(modifier = Modifier.fillMaxSize())
        }
    }
}

fun NavGraphBuilder.profileGraph(appState: CapstoneAppState) {
    composable(route = NavigationItem.ProfileScreen.route) {
        Column {
            Text(text = "Profile")
        }
    }
}

