package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import utils.CustomWaveShape

@Composable
fun ComplexComponent() {
    Box(modifier = Modifier.graphicsLayer { shape = CustomWaveShape() }.fillMaxWidth().background(color = Color.Green)) {
        Column{
            Text("Bonjour :) Vous êtes sur le composant complexe")
            Row() {
                Button(onClick = {}) {
                    Text("Click me !")
                }
            }
        }
    }
}
