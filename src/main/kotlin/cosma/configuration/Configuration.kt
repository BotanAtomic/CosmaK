package cosma.configuration

import javafx.beans.property.SimpleStringProperty
import tornadofx.ConfigProperties
import tornadofx.FX
import java.util.*
import javax.json.JsonObject

object Configuration {
    lateinit var themes: JsonObject
    var theme = SimpleStringProperty()
    var language = SimpleStringProperty()

    fun theme(): JsonObject {
        return themes.getJsonObject(theme.get())
    }

    fun init(config: ConfigProperties, themes: JsonObject) {
        Configuration.themes = themes

        theme.set(config.string("theme", "blue"))
        language.set(config.string("language"))

        if(language.get() != null) {
            FX.locale = Locale(language.get())
            Locale.setDefault(FX.locale)
        }

        println("Language : ${Locale.getDefault()}")
        println("Theme : ${theme.get()}")
    }

}