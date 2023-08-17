class FolderComposite : FileComponent{

    private var files: List<FileComponent>

    constructor(files: List<FileComponent>) {
        this.files = files
    }

    override fun showProperty() {
        for (file in this.files)
        {
            file.showProperty()
        }

    }

    override fun size(): Long {
        var total : Long = 0
        for (file in this.files) {
            total += file.size()
        }
        return total
    }

}