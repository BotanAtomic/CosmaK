package cosma.views

import com.jfoenix.controls.JFXScrollPane
import cosma.theme.Themeable
import javafx.scene.control.ScrollPane
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import tornadofx.*


class Sidebar() : View(), Themeable {
    override val root: ScrollPane by fxml("/views/sidebar.fxml")

    private val list: VBox by fxid()
    private val container: AnchorPane by fxid()

    init {
        root.useMaxHeight = true
        container.useMaxSize = true
        list.useMaxSize = true

        JFXScrollPane.smoothScrolling(root)

        list.style {
            backgroundColor += Color.RED
        }

        for (i in 1..19) {
            list.add(Rectangle(100.0, 100.0))
            //SidebarItem(MaterialDesignIcon.ANDROID, "Test dude")
        }
    }

    override fun applyTheme() {

    }

}
