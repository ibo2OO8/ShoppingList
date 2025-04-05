package com.ibrohimapk3.shoppinglist.domain

class DeleteItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteItem(shopItem: ShopItem) {
        shopListRepository.deleteItem(shopItem)
    }
}