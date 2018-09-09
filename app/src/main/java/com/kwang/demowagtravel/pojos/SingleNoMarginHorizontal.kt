package com.kwang.demowagtravel.pojos

class SingleNoMarginHorizontal {

    var images: Int = 0
    var title: String? = null
    var desc: String? = null

    var pubDate: String? = null
    var Margin: Int = 0

    constructor() {

    }

    constructor(images: Int, title: String, desc: String, pubDate: String) {
        this.images = images
        this.title = title
        this.desc = desc
        this.pubDate = pubDate
    }
}
