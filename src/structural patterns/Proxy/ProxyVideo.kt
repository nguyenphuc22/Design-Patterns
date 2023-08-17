class ProxyVideo : Video {



    private var realVideo : RealVideo ? = null
    private var url: String

    constructor(url: String) {
        this.url = url
    }


    override fun showVideo() {
        if (realVideo == null) {
            realVideo = RealVideo(this.url)
        } else {
            println("Video already exits:${this.url}")
        }
        realVideo?.showVideo()
    }
}