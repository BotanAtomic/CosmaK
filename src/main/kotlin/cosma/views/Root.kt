package cosma.views

import javafx.beans.property.SimpleStringProperty
import javafx.scene.layout.BorderPane
import tornadofx.*

class Root : View() {
    private val theme = SimpleStringProperty(this, "indigo", config.string("theme"))

    override val root : BorderPane by fxml("/views/root.fxml")

    init {
        println(theme)
    }
}
