package com.example.video_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView videoView;
MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=(VideoView)findViewById(R.id.video_view);
        if (mediaController==null)
        {
            mediaController=new MediaController(MainActivity.this);
            mediaController.setAnchorView(videoView);
        }
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(getApplicationContext(),"Video Is Finshed...!",Toast.LENGTH_LONG).show();
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(getApplicationContext(),"ErroR!.!",Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }
}