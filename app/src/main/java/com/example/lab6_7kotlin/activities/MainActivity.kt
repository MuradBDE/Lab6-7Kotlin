package com.example.lab6_7kotlin.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.lab6_7kotlin.fragments.MainFragment
import com.example.lab6_7kotlin.R
import com.example.lab6_7kotlin.fragments.ProductAdapter
import com.example.lab6_7kotlin.store.ProductCount
import com.example.lab6_7kotlin.store.STORE


class MainActivity : AppCompatActivity() {

    var ourPager: ViewPager? = null
    var ourAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ourPager = findViewById(R.id.main_pager)
        STORE.refreshEnabled()
        ourAdapter = ProductAdapter(supportFragmentManager, ourPager!!, STORE.enabledProducts)
        {productCount: ProductCount, adapter : ProductAdapter ->  MainFragment(productCount, adapter)}
        ourPager!!.adapter = ourAdapter
    }

}
