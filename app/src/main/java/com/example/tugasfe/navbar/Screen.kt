package com.example.tugasil.navbar

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Grid : Screen("grid")
    object About : Screen("about")
    object Detail : Screen("detail")
}