package com.ibrohimapk3.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.ibrohimapk3.shoppinglist.data.ShopListRepositoryImpl
import com.ibrohimapk3.shoppinglist.domain.DeleteItemUseCase
import com.ibrohimapk3.shoppinglist.domain.EditShopUseCase
import com.ibrohimapk3.shoppinglist.domain.GetShopUseCase
import com.ibrohimapk3.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    var shopListRepositoryImpl = ShopListRepositoryImpl

    private var getShopListUseCase = GetShopUseCase(shopListRepositoryImpl)
    private var deleteShopItemUseCase = DeleteItemUseCase(shopListRepositoryImpl)
    private var editShopItemUseCase = EditShopUseCase(shopListRepositoryImpl)

    var shopList = getShopListUseCase.getShopList()
    
    fun deleteShopList(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteItem(shopItem)
    }
    fun editShopList(shopItem: ShopItem) {
        var newItem = shopItem.copy(enabled = !shopItem.enabled) //shopItem ма копияша месозим
        editShopItemUseCase.editShopList(newItem)
    }
}