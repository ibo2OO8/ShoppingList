package com.ibrohimapk3.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun getShopList(): LiveData<List<ShopItem>>
    fun getShopItem(shopItemId : Int): ShopItem?
    fun editShopList(shopItem: ShopItem)
    fun addShopList(item : ShopItem)
    fun deleteItem(shopItem: ShopItem)
}