package com.ibrohimapk3.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrohimapk3.shoppinglist.domain.AddShopUseCase
import com.ibrohimapk3.shoppinglist.domain.EditShopUseCase
import com.ibrohimapk3.shoppinglist.domain.GetShopItem

class ShopItemViewModel: ViewModel() {
    private val getShopItem = GetShopItem()
    private val addShopItem = AddShopUseCase()
    private val editShopItem = EditShopUseCase()
}