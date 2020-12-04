package deu.cse.tos;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

public class CheckResultActivity extends AppCompatActivity {
    private Context mContext = CheckResultActivity.this;
    private static final int ACTIVITY_NUM = 4;
    private static final String TAG = "CheckResultActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0x00000000);  // transparent
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.addFlags(flags);
        }
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkresult);

        BarChart mBarChart2 = (BarChart) findViewById(R.id.barchart2);

        mBarChart2.addBar(new BarModel("아침",70f, 0xFF98BFBD));
        mBarChart2.addBar(new BarModel("점심",40f,  0xFF98BFBD));
        mBarChart2.addBar(new BarModel("저녁",45f, 0xFF98BFBD));
        mBarChart2.addBar(new BarModel("자기 전",55f, 0xFFDADADA));


        mBarChart2.bringToFront();
        mBarChart2.startAnimation();

    }








}