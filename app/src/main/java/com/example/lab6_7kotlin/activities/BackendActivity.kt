package com.example.lab6_7kotlin.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.lab6_7kotlin.fragments.BackendFragment
import com.example.lab6_7kotlin.R
import com.example.lab6_7kotlin.fragments.*
import com.example.lab6_7kotlin.store.*

class BackendActivity : AppCompatActivity() {
    var ourPager: ViewPager? = null
    var ourAdapter: ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("D", "Бэкенд запущен");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backend)

        ourPager = findViewById(R.id.backend_pager)
        ourAdapter = ProductAdapter(supportFragmentManager, ourPager!!, STORE.products)
        {productCount: ProductCount, adapter: ProductAdapter ->  BackendFragment(productCount, adapter)}
        ourPager!!.adapter = ourAdapter
    }

    fun addToStoreButton(view: View?): Unit {
        ourPager!!.isActivated = true
        STORE.addProduct(ourPager!!.currentItem)
        ourAdapter!!.refresh()
    }

    fun removeFromStoreButton(view: View?): Unit {
        if (STORE.products.size != 0) {
            STORE.removeProduct(ourPager!!.currentItem)
            ourAdapter!!.refresh()
        } else
            ourPager!!.isActivated = false
    }

}