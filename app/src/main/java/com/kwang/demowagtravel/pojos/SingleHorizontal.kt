package com.kwang.demowagtravel.pojos

class SingleHorizontal {

    var images: Int = 0
    var title: String? = null
    var desc: String? = null

    var pubDate: String? = null

    constructor() {

    }

    constructor(images: Int, title: String, desc: String, pubDate: String) {
        this.images = images
        this.title = title
        this.desc = desc
        this.pubDate = pubDate
    }
}
