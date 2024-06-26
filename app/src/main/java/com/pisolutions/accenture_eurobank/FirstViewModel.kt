package com.pisolutions.accenture_eurobank

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.lifecycle.AndroidViewModel
import com.pisolutions.accenture_eurobank.features.score.ScoreActivity

class FirstViewModel(application: Application) : AndroidViewModel(application) {

    fun createNotification() {


        val channel = NotificationChannel(
            "Message",
            "Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "Our Channel"
        val notificationManager =
            getApplication<Application>().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)


        val intent = Intent(getApplication(), ScoreActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(getApplication(), 5000, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(getApplication(), "Message")
        builder.setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Welcome to our app")
            .setContentText("Vassilis")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("blablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla")
            )
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify((5000..5500).random(), builder.build())
    }
}