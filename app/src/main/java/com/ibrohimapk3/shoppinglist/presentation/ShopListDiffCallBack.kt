package com.ibrohimapk3.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.ibrohimapk3.shoppinglist.domain.ShopItem

class ShopListDiffCallBack(
    private val oldList: List<ShopItem>,
    private val newList: List<ShopItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (newList[newItemPosition].id == oldList[oldItemPosition].id) true
        else false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }
}