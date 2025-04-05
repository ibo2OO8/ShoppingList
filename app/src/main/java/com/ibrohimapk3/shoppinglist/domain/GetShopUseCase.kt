package com.ibrohimapk3.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}