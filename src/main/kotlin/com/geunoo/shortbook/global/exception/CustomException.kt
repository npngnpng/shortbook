package com.geunoo.shortbook.global.exception

open class CustomException(
    override val message: String,
    val status: Int,
) : RuntimeException(message) {
}