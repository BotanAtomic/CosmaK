package cosma.app

import cosma.views.Root
import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus

class Application : App(Root::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}