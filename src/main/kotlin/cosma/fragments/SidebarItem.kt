package cosma.fragments

import cosma.configuration.Configuration
import cosma.entities.Bookmark
import cosma.events.ChangeThemeRequest
import cosma.utils.findIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.geometry.Pos
import javafx.scene.input.MouseButton
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*

class SidebarItem() : Fragment() {

    private val bookmark: Bookmark by param()

    private val defaultColor = c("#575757")
    private var iconView: MaterialDesignIconView by singleAssign()

    override val root = label {
        font = Font.font("14")
    }

    private fun setSkin() {
        val selected = bookmark.selected
        val theme = Configuration.theme()

        root.text = messages[bookmark.text]
        iconView.setIcon(findIcon(bookmark.icon))

        val color = if (selected) c(theme.getString("700")) else defaultColor
        val background = if (selected) c(theme.getString("700"), 0.2) else Color.WHITE

        root.style {
            textFill = color
            backgroundColor += background
        }
        iconView.style {
            fill = color
        }
        root.setOnMouseEntered {
            root.style(append = true) {
                if (!selected)
                    backgroundColor += c(theme.getString("700"), 0.2)
            }
        }

        root.setOnMouseExited {
            root.style(append = true) {
                backgroundColor += background
            }
        }
    }

    init {
        iconView = MaterialDesignIconView()

        iconView.size = "24"

        with(root) {
            prefHeight = 50.0
            useMaxWidth = true
            graphic = iconView
            graphicTextGap = 20.0
            padding = insets(0, 0, 0, 20)
            alignment = Pos.CENTER_LEFT
        }

        bookmark.selectedProperty.onChange { setSkin() }
        bookmark.textProperty.onChange { setSkin() }
        bookmark.iconProperty.onChange { setSkin() }

        root.setOnMouseClicked {
            if (it.button == MouseButton.PRIMARY) {
                bookmark.selected = true
            }
        }

        subscribe<ChangeThemeRequest> {
            setSkin()
        }

        setSkin()
    }

}


