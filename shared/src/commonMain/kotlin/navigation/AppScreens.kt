package navigation

import HomePage
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import ui.views.ComplexComponentScreen


object HomeScreen : Screen {
    @Composable
    override fun Content() {
        HomePage()
    }
}

object ComplexComponentScreen : Screen {
    @Composable
    override fun Content() {
        ComplexComponentScreen()
    }
}

