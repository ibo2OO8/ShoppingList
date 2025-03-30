package com.ibrohimapk3.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrohimapk3.shoppinglist.domain.ShopItem
import com.ibrohimapk3.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private var shopList = mutableListOf<ShopItem>()

    private var shopLD = MutableLiveData<List<ShopItem>>()

    init {
        addShopList(ShopItem("ads", 1, false))
        addShopList(ShopItem("adsr", 2, false))
        addShopList(ShopItem("adsd", 23, false))
        addShopList(ShopItem("ads", 3, false))
    }

    private var autoIncrementId = 0

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopLD
    }

    override fun getShopItem(shopItemId: Int): ShopItem? {
        return shopList.find {
            it.id == shopItemId
        }
    }

    override fun editShopList(shopItem: ShopItem) {
        var oldEl = getShopItem(shopItem.id)
        shopList.remove(oldEl)
        addShopList(shopItem)
    }

    override fun addShopList(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID){
            item.id = autoIncrementId++
        }
        shopList.add(item)
        updateList()
    }

    override fun deleteItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    private fun updateList() {
        shopLD.value = shopList.toList()
    }
}