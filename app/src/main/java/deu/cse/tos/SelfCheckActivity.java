package deu.cse.tos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.CheckBox;
import android.widget.TextView;



public class SelfCheckActivity extends AppCompatActivity implements View.OnClickListener {
    TextView selftext1;
    TextView selftext2;
    TextView selftext3;
    TextView selftext4;
    CheckBox check1 = (CheckBox) findViewById(R.id.checkbox1) ;

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
        setContentView(R.layout.activity_selfcheck);

        selftext1 = (TextView) findViewById(R.id.selfcheck1);
        selftext1.setOnClickListener(this);
        selftext2 = (TextView) findViewById(R.id.selfcheck2);
        selftext2.setOnClickListener(this);
        selftext3 = (TextView) findViewById(R.id.selfcheck3);
        selftext3.setOnClickListener(this);
        selftext4 = (TextView) findViewById(R.id.selfcheck4);
        selftext4.setOnClickListener(this);


        //Intent i = new Intent(this, CheckResultActivity.class);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.selfcheck1:
                // TextView가 클릭될 시 할 코드작성
                if(check1.isChecked()){
                    check1.setChecked(false);
                }else {
                    check1.setChecked(true);
                }

                System.out.println("1");
                break;

            case R.id.selfcheck2:
                // TextView가 클릭될 시 할 코드작성

                System.out.println("2");
                break;
            case R.id.selfcheck3:
                // TextView가 클릭될 시 할 코드작성

                System.out.println("3");
                break;
            case R.id.selfcheck4:
                // TextView가 클릭될 시 할 코드작성

                System.out.println("4");
                break;
        }
    }
}