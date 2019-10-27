package cosma.entity

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

class Bookmark(separator: Boolean = false, text: String? = null, icon: String? = null, button: Boolean = false) {
    val separatorProperty = SimpleBooleanProperty(separator)
    var separator by separatorProperty
    val textProperty = SimpleStringProperty(text)
    var text by textProperty
    val iconProperty = SimpleStringProperty(icon)
    var icon by iconProperty
    val buttonProperty = SimpleBooleanProperty(button)
    var button by buttonProperty
    val selectedProperty = SimpleBooleanProperty(false)
    var selected by selectedProperty
}
