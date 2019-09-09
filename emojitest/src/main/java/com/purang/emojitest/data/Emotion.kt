package com.purang.emojitest.data

open class Emotion() {
    var code: String? = null
    var uri: String? = null

    constructor(code: String?, uri: String?) : this() {
        this.code = code
        this.uri = uri
    }

}