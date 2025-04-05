package com.ibrohimapk3.shoppinglist.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.shoppinglist.R
import com.ibrohimapk3.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : ShopListAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
        adapter.onShopItemLongClick = object : ShopListAdapter.CallBackListener{
            override fun onShopItemLongClick(item: ShopItem) {
                viewModel.editShopList(item)
            }
        }
    }   
    fun setupRecyclerView(){
        var rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopListAdapter()
        rvShopList.adapter = adapter
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLED ,
            ShopListAdapter.RV_POOL)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DISABLED ,
            ShopListAdapter.RV_POOL)
    }
}