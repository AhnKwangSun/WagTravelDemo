package com.kwang.demowagtravel.pojos

import java.util.*

class SingleHorizontal {

    var images: Int = 0
    var wishList: Int = 0
    var infomation: String? = null
    var title: String? = null
    var serachDigit: String? = null
    var reserveStatus: String? = null
    var oldPrice: String? = null
    var renewalPrice: String? = null

    constructor() {

    }

    constructor(images: Int, infomation: String, title: String, searchDigit: String, reserveStatus: String, oldPrice: String, renewalPrice: String) {
        this.images = images
        this.infomation = infomation
        this.title = title
        this.serachDigit = searchDigit
        this.reserveStatus = reserveStatus + "예약"
        this.oldPrice = Currency.getInstance(Locale.KOREA).getSymbol() + oldPrice
        this.renewalPrice = Currency.getInstance(Locale.KOREA).getSymbol() + renewalPrice
    }
}
