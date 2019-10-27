package cosma.utils

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon

import java.io.File


fun findIcon(name: String): MaterialDesignIcon {
    return try {
        MaterialDesignIcon.valueOf(name.toUpperCase())
    } catch (e: IllegalArgumentException) {
        MaterialDesignIcon.HELP
    }
}

fun findIconByFile(file: File?): MaterialDesignIcon {
    if (file == null)
        return MaterialDesignIcon.HELP

    if (file.isDirectory) {
        val files = file.listFiles()

        return if (files != null && files.isNotEmpty()) MaterialDesignIcon.FOLDER else MaterialDesignIcon.FOLDER_OUTLINE
    }

    return MaterialDesignIcon.HELP
}

