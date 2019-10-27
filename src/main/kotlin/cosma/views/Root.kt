package cosma.views

import cosma.configuration.Configuration
import cosma.theme.Themeable
import tornadofx.View
import tornadofx.borderpane
import tornadofx.onChange

class Root : View(), Themeable {

    private val topBar: TopBar = TopBar()
    private val sidebar: Sidebar = Sidebar()

    override val root = borderpane {
        top = topBar.root
        left = sidebar.root
    }


    init {
        Configuration.init(config, resources.json("/themes.json"))
        Configuration.theme.onChange { applyTheme() }
        applyTheme()
    }

    override fun applyTheme() {
        println("Apply theme")
        topBar.applyTheme()
        sidebar.applyTheme()
    }
}
