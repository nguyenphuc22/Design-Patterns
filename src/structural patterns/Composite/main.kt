import java.util.*
fun main(args: Array<String>) {
    val file1: FileComponent = FileLeaf("file 1", 10)
    val file2: FileComponent = FileLeaf("file 2", 5)
    val file3: FileComponent = FileLeaf("file 3", 12)

    val files = Arrays.asList(file1, file2, file3)
    val folder: FileComponent = FolderComposite(files)

    folder.showProperty()
    println("Total Size: " + folder.size())
}