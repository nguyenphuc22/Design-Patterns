class FileLeaf : FileComponent {

    private var name:String
    private var size:Long

    constructor(name: String, size: Long) {
        this.name = name
        this.size = size
    }


    override fun showProperty() {
        System.out.println(this.name)
    }

    override fun size(): Long {
        return size;
    }
}