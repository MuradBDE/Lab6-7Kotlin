package com.example.lab6_7kotlin.fragments


import androidx.fragment.app.Fragment
import com.example.lab6_7kotlin.store.ProductCount

abstract class ProductFragment(var product: ProductCount, var adapter : ProductAdapter) : Fragment() {
    var mustBeRefreshed = true

    abstract fun refresh()
    abstract fun clear()
}