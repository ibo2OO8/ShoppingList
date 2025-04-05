package com.ibrohimapk3.shoppinglist.domain

class AddShopUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopList(item: ShopItem) {
        shopListRepository.addShopList(item)
    }
}