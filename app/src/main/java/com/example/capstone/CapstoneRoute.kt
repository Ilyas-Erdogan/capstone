package com.example.capstone

enum class Screen {
    REPORT,
    STATS,
    PROFILE
}

sealed class NavigationItem(val route: String) {
    data object ReportScreen : NavigationItem(Screen.REPORT.name)
    data object StatsScreen : NavigationItem(Screen.STATS.name)
    data object ProfileScreen : NavigationItem(Screen.PROFILE.name)
}