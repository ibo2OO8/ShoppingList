package com.ibrohimapk3.shoppinglist.presentation

import com.ibrohimapk3.shoppinglist.domain.ShopItem


interface CallBackListener {
    fun onShopItemLongClick(item: ShopItem)
}