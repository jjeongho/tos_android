package deu.cse.tos;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;



public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Uri uri = Uri.parse("android.resource://deu.cse.tos/" + R.raw.video);
        VideoView videoView = (VideoView)findViewById(R.id.videoview);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setVisibility(View.VISIBLE);




        Intent i = new Intent(this, SelfCheckActivity.class);

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
    }


}