package com.geunoo.shortbook.global.api.naver.dto

data class QueryNaverBookResponse(
    val items: List<Item>
)

data class Item(
    val title: String,
    val link: String,
    val image: String,
    val author: String,
    val isbn: String,
    val description: String,
)