package cosma.fragment

import de.jensd.fx.glyphs.GlyphsDude.createIconLabel
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import tornadofx.Fragment
import tornadofx.hbox
import tornadofx.useMaxWidth

class SidebarItem(icon: MaterialDesignIcon, label: String) : Fragment("My View") {
    override val root = hbox {
        prefHeight = 50.0
        useMaxWidth = true
        createIconLabel(icon, label, "24", "14", null)
    }
}
