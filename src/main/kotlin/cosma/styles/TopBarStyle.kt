package cosma.styles

import cosma.configuration.Configuration
import javafx.scene.paint.Color
import tornadofx.*

class TopBarStyle() : Stylesheet() {

    companion object {
        val anchorPane by cssclass()
        val buttons by cssclass()
        val jfxRippler by cssclass()
        val jfxRipplerFill by cssproperty<Color>("-jfx-rippler-fill")
    }

    init {
        val theme = Configuration.theme()
        anchorPane {
            backgroundColor.add(c(theme.getString("700")))
        }

        buttons {
            jfxRippler {
                jfxRipplerFill.value = c(theme.getString("800"))
            }
            backgroundRadius += box(30.px)
            borderRadius += box(30.px)
        }
    }
}
