package app.tinks.composenavigationdemo

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MyNavHost(navController = navController)
        }
    }

    // Unit test
    @Test
    fun appNavHost_verifyStartDestination() {
        composeTestRule
            .onNodeWithText("This is Home Screen")
            .assertIsDisplayed()
    }

    @Test
    fun appNavHost_clickAllProfiles_navigateToDestination() {
        composeTestRule.onNodeWithText("Go to Destination")
            .performClick()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, Screen.TestScreen.route)
        composeTestRule.onNodeWithText("This is Destination Screen")
            .assertIsDisplayed()
    }


}