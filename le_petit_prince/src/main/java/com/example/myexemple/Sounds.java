package com.example.myexemple;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Sounds extends AppCompatActivity implements SoundPool.OnLoadCompleteListener {
    private SoundPool mSoundPool;
    private int mClopSound, mVoiceSound;
    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sounds);

        mSoundPool= new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        mSoundPool.setOnLoadCompleteListener(this);


        mVoiceSound=mSoundPool.load(this,R.raw.kamera_motor,5);
        mClopSound=mSoundPool.load(this,R.raw.zvuk_hlopushki,2);
    }

    public void onClicedHlop(View view) {
        mSoundPool.play(mVoiceSound,1,1,5,0,1);
        mSoundPool.play(mClopSound,1,1,2,0,1);

    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

    }
}
