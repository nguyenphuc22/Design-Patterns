class RealVideo : Video {

    var url : String

    constructor(url: String) {
        this.url = url
        println("Video loaded: ${this.url}")
    }


    override fun showVideo() {
        println("Video Showed: ${this.url}")
    }

}