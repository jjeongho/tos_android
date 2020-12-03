package deu.cse.tos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {
    private Context mContext = MainActivity.this;
    private static final int ACTIVITY_NUM = 0;
    private static final String TAG = "MainActivity";
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavigationView;
    QnAFragment qnaFragement = new QnAFragment();
    MainFragment mainFragement = new MainFragment();
    InformationFragment informationFragement = new InformationFragment();
    CalendarFragment calendarFragement = new CalendarFragment();

//    private void initActivity() {
//        Window window = getWindow();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(0x00000000);  // transparent
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            int flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            window.addFlags(flags);
//        }
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        initActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_layout,mainFragement).commitAllowingStateLoss();
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragmentTransaction = fragmentManager.beginTransaction();
                switch(item.getItemId()) {
                    case R.id.callHome:
                        fragmentTransaction.replace(R.id.main_layout,mainFragement).commitAllowingStateLoss();
                        break;
                    case R.id.callQnA:
                        fragmentTransaction.replace(R.id.main_layout,qnaFragement).commitAllowingStateLoss();
                        break;
                    case R.id.callCalendar:
                        fragmentTransaction.replace(R.id.main_layout,calendarFragement).commitAllowingStateLoss();
                        break;
                    case R.id.callInformation:
                        fragmentTransaction.replace(R.id.main_layout,informationFragement).commitAllowingStateLoss();
                        break;
                }
                return false;
            }
        });

//        ImageButton button = (ImageButton) findViewById(R.id.brushimageButton);
//        Intent i = new Intent(this, VideoActivity.class);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(i);
//
//            }
//
//        });
    }

    private void setupBottomNavigationView(){
//        BottomNavigationHelper.enableNavigation(mContext, bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
//        menuItem.setChecked(true);
    }


}