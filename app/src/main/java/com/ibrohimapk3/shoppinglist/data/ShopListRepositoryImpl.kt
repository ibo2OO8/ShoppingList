package com.ibrohimapk3.shoppinglist.data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrohimapk3.shoppinglist.domain.ShopItem
import com.ibrohimapk3.shoppinglist.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private var shopList = mutableListOf<ShopItem>()

    private var shopLD = MutableLiveData<List<ShopItem>>()

    init {
       for (i in 0..20){
           addShopList(ShopItem("name $i" , i , Random.nextBoolean()))
       }
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
        val index = shopList.indexOfFirst { it.id == shopItem.id }
        if (index != -1) {
            shopList[index] = shopItem
            updateList()
        }
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