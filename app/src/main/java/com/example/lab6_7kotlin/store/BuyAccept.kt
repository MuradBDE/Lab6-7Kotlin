package com.example.lab6_7kotlin.store

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.lab6_7kotlin.R
import com.example.lab6_7kotlin.fragments.ProductAdapter


class BuyAccept(val adapter: ProductAdapter, val product : ProductCount) {

    fun OnSuccess(){
        adapter.refresh(false)

        val builder = NotificationCompat.Builder(adapter.pager.context)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Покупка")
            .setContentText("Покупка " + product.product.name + " успешно завершена")

        val notification: Notification = builder.build()

        val notificationManager = adapter.pager.context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.notify(notification_index, notification)
        notification_index++
    }

    fun onError(){
        adapter.refresh(false)

        val builder = NotificationCompat.Builder(adapter.pager.context)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Ошибка")
            .setContentText("Покупка " + product.product.name + " отменена")

        val notification: Notification = builder.build()

        val notificationManager = adapter.pager.context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.notify(notification_index, notification)
        notification_index++
    }
}
private var notification_index = 0