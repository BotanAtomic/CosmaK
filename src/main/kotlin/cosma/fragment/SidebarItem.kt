package cosma.fragment

import cosma.configuration.Configuration
import cosma.entity.Bookmark
import cosma.utils.findIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.geometry.Pos
import javafx.scene.input.MouseButton
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*

class SidebarItem(bookmark: Bookmark) : Fragment() {
    private val defaultColor = c("#575757")
    private var iconView: MaterialDesignIconView by singleAssign()

    override val root = label(bookmark.textProperty) {
        font = Font.font("14")
    }

    private fun applyStyle(selected: Boolean) {
        val theme = Configuration.theme()
        root.style {
            textFill = if (selected) c(theme.getString("700")) else defaultColor
            backgroundColor += if (selected) c(theme.getString("700"), 0.2) else Color.WHITE
        }
        iconView.style {
            fill = if (selected) c(theme.getString("700")) else defaultColor
        }
        root.setOnMouseEntered {
            root.style(append = true) {
                if (!selected)
                    backgroundColor += c(theme.getString("700"), 0.2)
            }
        }

        root.setOnMouseExited {
            root.style(append = true) {
                backgroundColor += if (selected) c(theme.getString("700"), 0.2) else c("white")
            }
        }
    }

    init {
        iconView = MaterialDesignIconView(findIcon(bookmark.icon))

        iconView.size = "24"

        with(root) {
            prefHeight = 50.0
            useMaxWidth = true
            graphic = iconView
            graphicTextGap = 20.0
            padding = tornadofx.insets(0, 0, 0, 20)
            alignment = Pos.CENTER_LEFT
        }

        bookmark.selectedProperty.addListener { _, _, selected ->
            run {
                applyStyle(selected)
            }
        }

        applyStyle(bookmark.selected)

        root.setOnMouseClicked {
            if (it.button == MouseButton.PRIMARY) {
                bookmark.selected = true
            }
        }
    }

}


