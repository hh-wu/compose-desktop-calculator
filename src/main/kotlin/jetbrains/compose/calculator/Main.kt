package jetbrains.compose.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import jetbrains.compose.calculator.resources.lightThemeColors
import jetbrains.compose.calculator.view.DisplayPanel
import jetbrains.compose.calculator.view.Keyboard

const val DEFAULT_WIDTH = 500
const val DEFAULT_HEIGHT = 500

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose Calculator",
        state = rememberWindowState(width = DEFAULT_WIDTH.dp, height = DEFAULT_HEIGHT.dp),
        icon = painterResource("icon.png")
    ) {
        MaterialTheme(colors = lightThemeColors) {
            val mainOutput = remember { mutableStateOf(TextFieldValue("0")) }
            Column(Modifier.fillMaxHeight()) {
                DisplayPanel(
                    Modifier.weight(1f),
                    mainOutput
                )
                Keyboard(
                    Modifier.weight(4f),
                    mainOutput
                )
            }
        }
    }
}

