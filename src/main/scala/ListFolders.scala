import java.io.File

object ListFolders extends App {

    def printLF(dir: String): Unit = {
        val d = new File(dir)
        if (d.exists && d.isDirectory) {
            d.listFiles.toList.foreach { folder =>
                println(folder)
                if (folder.exists && folder.isDirectory) printLF(s"$folder")
            }
        }
    }
    printLF(args(0))
}
