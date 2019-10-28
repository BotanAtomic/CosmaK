package cosma.views

import com.jfoenix.controls.JFXScrollPane.smoothScrolling
import cosma.entities.Bookmark
import cosma.events.ChangeThemeRequest
import cosma.fragments.SidebarItem
import cosma.theme.Themeable
import javafx.collections.FXCollections
import javafx.scene.control.ScrollPane
import javafx.scene.control.Separator
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import tornadofx.View
import tornadofx.onChange
import tornadofx.useMaxHeight


class Sidebar : View(), Themeable {
    override val root: ScrollPane by fxml("/views/sidebar.fxml")

    private val list: VBox by fxid()
    private val container: AnchorPane by fxid()

    private var items = FXCollections.observableArrayList<Bookmark>()

    init {
        container.prefWidthProperty().bind(root.widthProperty())
        list.prefWidthProperty().bind(container.widthProperty())
        root.useMaxHeight = true

        smoothScrolling(root)

        items.onChange {
            it.next()
            it.addedSubList.forEach { bookmark ->
                if (!bookmark.separator) {
                    list.add(find<SidebarItem>("bookmark" to bookmark))
                } else
                    list.add(Separator())

                bookmark.selectedProperty.addListener { _, _, selected ->
                    if (selected)
                        items.filter { item -> item != bookmark }
                            .forEach { item -> item.selected = false }
                }
            }
        }

        items.addAll(
            Bookmark(text = "Recent", icon = "history"),
            Bookmark(text = "Favorites", icon = "heart"),
            Bookmark(separator = true),
            Bookmark(text = "Home", icon = "home"),
            Bookmark(text = "Desktop", icon = "monitor"),
            Bookmark(text = "Documents", icon = "file_document"),
            Bookmark(text = "Downloads", icon = "download"),
            Bookmark(text = "Music", icon = "volume_high"),
            Bookmark(text = "Pictures", icon = "image"),
            Bookmark(text = "Videos", icon = "video"),
            Bookmark(text = "Trash", icon = "delete"),
            Bookmark(separator = true),
            Bookmark(text = "LinuxFiles", icon = "linux"),
            Bookmark(separator = true),
            Bookmark(text = "GoogleDrive", icon = "google_drive", button = true)
        )
    }

    override fun applyTheme() {
        fire(ChangeThemeRequest("Hello"))
    }

}
