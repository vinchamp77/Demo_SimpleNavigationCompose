package com.example.simplenavigationcompose.ui.navigation

sealed class NavRoute(val path: String) {

    object Login: NavRoute("login")

    object Home: NavRoute("home")

    object Profile: NavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Search: NavRoute("search") {
        val query = "query"
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}


