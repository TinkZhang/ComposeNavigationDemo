package app.tinks.composenavigationdemo

import androidx.annotation.StringRes

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object HomeScreen : Screen("home", R.string.home)
    object TestScreen : Screen("test", R.string.test)
}

val topLevelScreen = listOf(Screen.HomeScreen, Screen.TestScreen)