package cosma.views

import cosma.configuration.Configuration
import cosma.events.ChangeThemeRequest
import cosma.theme.Themeable
import javafx.scene.layout.BorderPane
import javafx.scene.layout.StackPane
import tornadofx.View
import tornadofx.borderpane
import tornadofx.onChange
import tornadofx.useMaxSize

class Root : View(), Themeable {

    private val topBar: TopBar by inject()
    private val sidebar: Sidebar by inject()

    private val mainView: Main = Main()

    override val root = StackPane()

    init {
        Configuration.init(config, resources.json("/themes.json"))
        Configuration.theme.onChange { applyTheme() }

        with(root) {
            borderpane {
                top = topBar.root
                left = sidebar.root
                center = mainView.root
            }
            useMaxSize = true
        }


        subscribe<ChangeThemeRequest> {
            println("Receive event 2 !")
        }

        applyTheme()
    }

    override fun applyTheme() {
        println("Apply theme")
        topBar.applyTheme()
        sidebar.applyTheme()
    }
}
