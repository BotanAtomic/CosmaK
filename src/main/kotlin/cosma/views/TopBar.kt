package cosma.views

import cosma.styles.TopBarStyle
import cosma.theme.Themeable
import javafx.scene.layout.AnchorPane
import tornadofx.View
import tornadofx.addClass
import tornadofx.importStylesheet
import tornadofx.removeStylesheet


class TopBar() : View(), Themeable {
    override val root: AnchorPane by fxml("/views/top.fxml")

    override fun applyTheme() {
        removeStylesheet<TopBarStyle>()
        importStylesheet<TopBarStyle>()

        root.addClass(TopBarStyle.anchorPane)

        root.lookupAll(".button").addClass(TopBarStyle.buttons)
    }

}
