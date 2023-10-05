package ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.components.ComplexComponent

@Composable
fun ComplexComponentScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ComplexComponent()
    }
}
