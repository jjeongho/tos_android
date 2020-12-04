package deu.cse.tos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;


import java.util.Timer;
import java.util.TimerTask;


public class VideoActivity extends AppCompatActivity {
    int counter = 0;
    ProgressBar videobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        prog();

        Intent i = new Intent(this, SelfCheckActivity.class);
        TextView textView = (TextView) findViewById(R.id.video_mode_txt);
        Uri uri = Uri.parse("android.resource://deu.cse.tos/" + R.raw.video);
        VideoView videoView = (VideoView) findViewById(R.id.videoview);
        videoView.setVideoURI(uri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                videoView.start();           // start the video
                videoView.setVisibility(View.VISIBLE);
            }

        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                textView.setText("양치가 끝났어요 !!");
                startActivity(i);
            }
        });

        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                    finish();
                }
                return true;
            }
        });

    }
        public void prog () {
            videobar = (ProgressBar) findViewById(R.id.videobar);

            final Timer t = new Timer();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    counter++;
                    videobar.setProgress(counter);

                    if (counter == 100)
                        t.cancel();
                }

        } ;

        t.schedule(tt, 10, 117);

    }

}

//        Intent i = new Intent(this, SelfCheckActivity.class);

//        imageview.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                startActivity(i);
//
//            }
//
//            @Override
//            public void onTouch(View view) {
//
//
//            }
//
//        });



