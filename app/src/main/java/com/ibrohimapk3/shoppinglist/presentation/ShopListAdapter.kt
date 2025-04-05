package com.ibrohimapk3.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.shoppinglist.R
import com.ibrohimapk3.shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onShopItemLongClick : CallBackListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShopItemViewHolder {
        var layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("hello")
        }
        var view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        var shopItem = shopList[position]
        holder.itemView.setOnLongClickListener {
            onShopItemLongClick?.onShopItemLongClick(shopItem)
            true

        }
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        var item = shopList[position]
        return if (item.enabled)
            VIEW_TYPE_ENABLED
        else VIEW_TYPE_DISABLED
    }

    override fun getItemCount(): Int = shopList.size

    class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName = view.findViewById<TextView>(R.id.tv_name)
        var tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    companion object {
        var VIEW_TYPE_ENABLED = 1
        var VIEW_TYPE_DISABLED = 0

        var RV_POOL = 20
    }

    interface CallBackListener {
        fun onShopItemLongClick(item: ShopItem)
    }
}