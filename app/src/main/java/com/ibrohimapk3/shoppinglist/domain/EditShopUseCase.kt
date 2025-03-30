package com.ibrohimapk3.shoppinglist.domain

class EditShopUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopList(shopItem: ShopItem) {
        shopListRepository.editShopList(shopItem)

    }
}