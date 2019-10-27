package cosma.styles

import cosma.configuration.Configuration
import javafx.scene.paint.Color
import tornadofx.Stylesheet
import tornadofx.cssclass

class SidebarStyle() : Stylesheet() {

    companion object {
        val whiteBackground by cssclass()
    }

    init {
        val theme = Configuration.theme()
        whiteBackground {
            backgroundColor.add(Color.WHITE)
        }

    }
}
