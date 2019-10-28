package cosma.dialogs

import com.jfoenix.controls.JFXDialog
import cosma.configuration.Configuration
import cosma.views.Root
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.View
import tornadofx.c
import tornadofx.circle
import tornadofx.flowpane

class ThemeChooser() : View() {
    override val root = JFXDialog()

    private val rootView: Root by inject()

    init {
        val themes = Configuration.themes
        val theme = Configuration.theme

        root.content = flowpane {
            prefWrapLength = 400.0
            alignment = Pos.TOP_CENTER
            vgap = 20.0
            hgap = 20.0
            prefWidth = 340.0
            prefHeight = 240.0
            padding = tornadofx.insets(20)

            themes.keys.forEach {
                circle {
                    fill = c(themes.getJsonObject(it).getString("500"))
                    radius = 20.0

                    if (it == theme.get()) {
                        stroke = Color.BLACK
                    }

                    setOnMouseClicked { _ ->
                        Configuration.theme.set(it)
                    }
                }
            }
        }

        root.dialogContainer = rootView.root

    }

    fun show() {
        root.show()
    }
}
