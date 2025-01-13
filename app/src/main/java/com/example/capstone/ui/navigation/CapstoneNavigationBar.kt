package com.example.capstone.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.capstone.NavigationItem
import com.example.capstone.R

@Composable
fun CapstoneNavigationBar(
    navigateTo: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    val items = listOf("Report", "Stats", "Profile")
    val capstoneNavigationItems = listOf(
        NavigationItem.ReportScreen.route,
        NavigationItem.StatsScreen.route,
        NavigationItem.ProfileScreen.route
    )

    val selectedIcons = listOf(
        R.drawable.baseline_difference_24,
        R.drawable.baseline_graphic_eq_24,
        R.drawable.baseline_person_24
    )

    val unselectedIcons = listOf(
        R.drawable.outline_difference_24,
        R.drawable.baseline_graphic_eq_24,
        R.drawable.outline_person_24
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index)
                            painterResource(selectedIcons[index])
                        else
                            painterResource(unselectedIcons[index]),
                        contentDescription = item
                    )
                },
                label = { Text(text = item) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navigateTo(capstoneNavigationItems[index])
                }
            )

        }
    }

}