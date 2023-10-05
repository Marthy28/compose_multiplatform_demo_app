package utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CustomWaveShape (private  val waveCount : Int = 20) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(path = drawWavePath(size, waveCount))
    }

    private fun drawWavePath(size: Size, waveCount: Int): Path {
        val waveLength = size.width / (waveCount + 1)
        val waveHeight = waveLength / 5
        val gap = 3*waveLength/4
        return Path().apply {
            reset()
            moveTo(0f, 0f)
            arcTo(
                rect = Rect(topLeft = Offset(-waveLength/4, 0f),
                    bottomRight = Offset(waveLength / 4, waveHeight)),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            arcTo(
                rect = Rect(topLeft = Offset(waveLength / 4, 0f),
                    bottomRight = Offset(gap, waveHeight)),
                startAngleDegrees = 180f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false
            )
            for (i in 1..waveCount) {
                arcTo(
                    rect = Rect(topLeft = Offset(gap + waveLength * (i-1), 0f),
                        bottomRight = Offset(gap + waveLength * (i-1) + waveLength/2, waveHeight)),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
                arcTo(
                    rect = Rect(topLeft = Offset(gap + waveLength * (i-1) + waveLength/2, 0f),
                        bottomRight = Offset(gap + waveLength * i, waveHeight)),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false
                )
            }
            arcTo(
                rect = Rect(topLeft = Offset(size.width - waveLength/4, 0f),
                    bottomRight = Offset(size.width + waveLength/4, waveHeight)),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(size.width, size.height)
            arcTo(
                rect = Rect(
                    topLeft = Offset(size.width - waveLength/4, size.height - waveHeight),
                    bottomRight = Offset(size.width + waveLength/4, size.height)),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            arcTo(
                rect = Rect(
                    topLeft = Offset(size.width - gap,
                        size.height - waveHeight),
                    bottomRight = Offset(size.width - waveLength/4, size.height)),
                startAngleDegrees = 0f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false
            )
            for (i in 1..waveCount) {
                arcTo(rect = Rect(
                    topLeft = Offset(size.width - gap - waveLength*(i-1) - waveLength/2,
                        size.height - waveHeight),
                    bottomRight = Offset(size.width - gap - waveLength*(i-1),
                        size.height)),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
                arcTo(
                    rect = Rect(
                        topLeft = Offset(size.width - gap - waveLength * i,
                            size.height - waveHeight),
                        bottomRight = Offset(size.width - gap - waveLength*(i-1) - waveLength/2,
                            size.height)),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false
                )
            }
            arcTo(
                rect = Rect(topLeft = Offset(-waveLength/4, size.height - waveHeight),
                    bottomRight = Offset(waveLength/4, size.height)),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            close()
        }
    }

}
