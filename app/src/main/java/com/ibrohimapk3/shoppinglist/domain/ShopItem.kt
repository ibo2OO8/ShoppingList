package com.ibrohimapk3.shoppinglist.domain

data class ShopItem(
    var id: Int,
    val name: String,
    val count: Int,
    var enabled: Boolean
)
