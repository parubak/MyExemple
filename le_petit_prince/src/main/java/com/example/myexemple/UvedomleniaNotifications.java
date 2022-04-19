package com.example.myexemple;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class UvedomleniaNotifications extends AppCompatActivity {

    public static final int NOTIFICATION_ID=1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uvedomlenia_notifications);

    }

    public void buttonDzwon(View view) {
        /*setSmallIcon() (установить маленькую иконку ) — иконку
        можно выбрать из библиотеки Android Studio или загрузить свою;
        Важно!Важно!
                К иконкам для уведомлений предъявляются достаточно четкие
        требования: изображения иконок должны быть небольшого
        размера и иметь прозрачный фон (соответственно должны быть сохранены в формате .png).
         Иначе они будут отображаться сплошным темным квадратом или не будут отображаться вовсе.
        2) setContentTitle() (установить заголовок контента );
        3) setContentText() (установить текст контента )*/
        NotificationCompat.Builder nbuilder=
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        //СНОВНИЕ 3
                        .setSmallIcon(R.drawable.colocol_smoll)
                        .setContentTitle("Kolocol smol")
                        .setContentText("Колокольчик смол звенит!")
                        // ДОПОЛНИТЕЛЬНЫЕ
        .setAutoCancel(true)    //(установить автоматическое завершение )
        .setLargeIcon(BitmapFactory.decodeResource(this.getResources()
                ,R.drawable.colocol_smoll)) //(установить большую иконку )
        .setPriority(NotificationCompat.PRIORITY_HIGH) //(установить приоритет, высокий приоритет  )
        .setDefaults(NotificationCompat.DEFAULT_LIGHTS)
        .setDefaults(NotificationCompat.DEFAULT_SOUND)
        .setDefaults(NotificationCompat.DEFAULT_VIBRATE) //разу все ( DEFAULT_ALL)
//.setProgress(0, 0, true) //(установить прогресс )
        .setVisibility(NotificationCompat.VISIBILITY_SECRET)
        /*VISIBILITY_PUBLIC (общая видимость ) на экране блокировки будет показано полное содержимое уведомления;
        VISIBILITY_PRIVATE («частная», то есть частичная видимость) будет показана часть уведомления,
        например название или имя отправителя; при VISIBILITY_SECRET (видимость секретная )
        уведомление не будет отображаться на экране блокировки вовсе:*/
                ;
        /*Dля того чтобы при нажатии на уведомление открывалось
        наше приложение, нужно использовать объект Intent.
        Intent (намерение) — это абстрактное описание одной выполняемой операции, с помощью которого
        можно запросить выполнение некоторого действия у другой Activity или даже стороннего приложения.
        Объявим Intent и укажем, что открываться должен главный
        экран нашего приложения — MainActivity*/
        Intent resIntent=new Intent(this,UvedomleniaNotifications.class);

        /*Для выстраивания навигации при взаимодействии с уведомлением объявляется объект
        TaskStackBuilder (построитель стеказадач) stackBuilder — своего рода список, в который будут
        заноситься задачи по мере их выполнения, в нашем случае — вызовы Activity*/
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);

        /*Метод addParentStack() (добавить родительский стек ) устанавливает в качестве родительского
        стека класс MainActivity Но у нас в приложении сейчас только один экран — MainActivity,
        поэтому он упоминается и как родительский стек, и как resultIntent (результирующее намерение ).
        Если бы их было несколько, то при нажатии на уведомление мы попадали бы на экран, заданный
        как resultIntent, а при нажатии кнопки «назад» попадали бы на «родительский», то есть домаш-
        ний, экран.*/
        stackBuilder.addParentStack(UvedomleniaNotifications.class);
        stackBuilder.addNextIntent(resIntent);

       /* Объект PendingIntent (в ожидании намерения ) представляет собой некоторую «оболочку» для
       объекта Intent и содержит его описание и определение действий, которые будут над ним выпол-
       няться в дальнейшем. В нашем случае, при нажатии на уведом ление будет открываться Activity,
       которая находилась в стекезадач, сформированном в объекте TaskStackBuilder, то есть наш
        единственный экран MainActivity.*/
        PendingIntent resPendingIntent=stackBuilder.getPendingIntent
                (0,PendingIntent.FLAG_UPDATE_CURRENT);
        nbuilder.setContentIntent(resPendingIntent);
        NotificationManager mNotificationManager=
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

       /* Для того чтобы «собрать» и отобразить уведомление и иметь
        возможность обновлять его в дальнейшем*/
        mNotificationManager.notify(NOTIFICATION_ID,nbuilder.build());


    }
}
