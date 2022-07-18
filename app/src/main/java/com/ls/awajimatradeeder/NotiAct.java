package com.ls.awajimatradeeder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

@SuppressWarnings("deprecation")
public class NotiAct extends AppCompatActivity {
    private Uri soundUri;
    private Bundle bundle;
    private String contentTitle,contentText,ticker;
    private AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_noti);
        bundle= getIntent().getExtras();
        if(bundle !=null){
            contentTitle=bundle.getString("tittle");
            contentText=bundle.getString("content");
            ticker=bundle.getString("ticker");
            activity=bundle.getParcelable("activity");
        }
        Intent intento = new Intent(NotiAct.this, activity.getClass());
        //intento.putExtra("versionnueva",VersionNueva);
        //intento.putExtra("versionactual",VersionActual);

        intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(NotiAct.this, 0, intento, PendingIntent.FLAG_UPDATE_CURRENT);

        soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification noti = new NotificationCompat.Builder(NotiAct.this)
                .setContentIntent(pIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.drawable.ic_alert)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setSound(soundUri)
                .build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;


        notificationManager.notify(0, noti);
    }
}