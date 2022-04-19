package com.example.myexemple;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;

public class Le_Petit_Prince extends AppCompatActivity {

    private Button button_morning, button_Day, button_Evening,button_Night;
    private ImageView imageMorning, imageDay, imageEvening, imageNight;
    private ConstraintLayout layoutMorning;

    public static final int notificationMorning=1;
    public static final int notificationDay=2;
    public static final int notificationEvening=3;
    public static final int notificationNight=4;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.le_petit_prince);

        button_morning=(Button) findViewById(R.id.button_morning);
        button_Day=(Button) findViewById(R.id.button_Day);
        button_Evening=(Button) findViewById(R.id.button_Evening);
        button_Night=(Button) findViewById(R.id.button_Night);

        imageMorning=(ImageView) findViewById(R.id.imageMorning);
        imageDay=(ImageView) findViewById(R.id.imageDay);
        imageEvening=(ImageView) findViewById(R.id.imageEvening);
        imageNight=(ImageView) findViewById(R.id.imageNight);

        layoutMorning=findViewById(R.id.layoutMorning);
    }

    public void btnMorningClick(View view) {
        imageMorning.setVisibility(View.VISIBLE);
        imageDay.setVisibility(View.INVISIBLE);
        imageEvening.setVisibility(View.INVISIBLE);
        imageNight.setVisibility(View.INVISIBLE);
        Notification.Builder nbuilder=new Notification.Builder(this)
                .setSmallIcon(R.drawable.cleaning)
                .setContentTitle("Утро")
                .setContentText("Привести в порядок свою планету.")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setVisibility(Notification.VISIBILITY_PUBLIC);
        Intent resIntent=new Intent(this,Le_Petit_Prince.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Le_Petit_Prince.class);
        stackBuilder.addNextIntent(resIntent);

        PendingIntent resPendingIntent=stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        nbuilder.setContentIntent(resPendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationMorning, nbuilder.build());
    }

    public void btnDayClick(View view) {
        imageMorning.setVisibility(View.INVISIBLE);
        imageDay.setVisibility(View.VISIBLE);
        imageEvening.setVisibility(View.INVISIBLE);
        imageNight.setVisibility(View.INVISIBLE);
        Notification.Builder nbuilder=new Notification.Builder(this)
                .setSmallIcon(R.drawable.rose)
                .setContentTitle("День")
                .setContentText("Полить розу")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setVisibility(Notification.VISIBILITY_PUBLIC);
        Intent resIntent=new Intent(this,Le_Petit_Prince.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Le_Petit_Prince.class);
        stackBuilder.addNextIntent(resIntent);

        PendingIntent resPendingIntent=stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        nbuilder.setContentIntent(resPendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationDay, nbuilder.build());
    }

    public void btnEveningClick(View view) {
        imageMorning.setVisibility(View.INVISIBLE);
        imageDay.setVisibility(View.INVISIBLE);
        imageEvening.setVisibility(View.VISIBLE);
        imageNight.setVisibility(View.INVISIBLE);
        Notification.Builder nbuilder=new Notification.Builder(this)
                .setSmallIcon(R.drawable.home)
                .setContentTitle("Вечер")
                .setContentText("Закрыть розу ширмой")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setVisibility(Notification.VISIBILITY_PUBLIC);
        Intent resIntent=new Intent(this,Le_Petit_Prince.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Le_Petit_Prince.class);
        stackBuilder.addNextIntent(resIntent);

        PendingIntent resPendingIntent=stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        nbuilder.setContentIntent(resPendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationEvening, nbuilder.build());
    }

    public void btnNightClick(View view) {
        imageMorning.setVisibility(View.INVISIBLE);
        imageDay.setVisibility(View.INVISIBLE);
        imageEvening.setVisibility(View.INVISIBLE);
        imageNight.setVisibility(View.VISIBLE);
        Notification.Builder nbuilder=new Notification.Builder(this)
                .setSmallIcon(R.drawable.sunset)
                .setContentTitle("Ночь")
                .setContentText("По-любоваться закатом")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setVisibility(Notification.VISIBILITY_PUBLIC);
        Intent resIntent=new Intent(this,Le_Petit_Prince.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Le_Petit_Prince.class);
        stackBuilder.addNextIntent(resIntent);

        PendingIntent resPendingIntent=stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        nbuilder.setContentIntent(resPendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationNight, nbuilder.build());
    }

    public void onPrinceClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Маленький принц!", android.widget.Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();

    }

    public void onPlanetClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Астероид Б-612. Планета, на которой живет Маленький принц!", android.widget.Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
    }

    public void onVolcanoClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Потух-ший вулкан. О нем тоже нужно заботиться!", android.widget.Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
    }

    public void onBreakfastClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Действующий вулкан. Н а нем удобно разогревать завтрак.", android.widget.Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
    }

    public void onRoseClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Роза. Ее нужно поливать, а на ночь укрывать ширмой и колпаком!", android.widget.Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();
    }
}
