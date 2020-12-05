package deu.cse.tos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;



public class SelfCheckActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView selftext1;
    private TextView selftext2;
    private TextView selftext3;
    private TextView selftext4;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;


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

        check1 = (CheckBox) findViewById(R.id.checkbox1);
        check2 = (CheckBox) findViewById(R.id.checkbox2);
        check3 = (CheckBox) findViewById(R.id.checkbox3);
        check4 = (CheckBox) findViewById(R.id.checkbox4);
        selftext1 = (TextView) findViewById(R.id.selfcheck1);
        selftext2 = (TextView) findViewById(R.id.selfcheck2);
        selftext3 = (TextView) findViewById(R.id.selfcheck3);
        selftext4 = (TextView) findViewById(R.id.selfcheck4);

        Intent i = new Intent(this, CheckResultActivity.class);
        selftext1.setOnClickListener(this);
        selftext2.setOnClickListener(this);
        selftext3.setOnClickListener(this);
        selftext4.setOnClickListener(this);

        Button button=findViewById(R.id.btn_register2);
        button.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                startActivity(i);
                System.out.println("화면 전환 성공");
            }
        });
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.selfcheck1:
                if(check1.isChecked()){
                    check1.setChecked(false);
                }else {
                    check1.setChecked(true);
                }
                break;

            case R.id.selfcheck2:
                if(check2.isChecked()){
                    check2.setChecked(false);
                }else {
                    check2.setChecked(true);
                }
                break;
            case R.id.selfcheck3:
                if(check3.isChecked()){
                    check3.setChecked(false);
                }else {
                    check3.setChecked(true);
                }
                break;
            case R.id.selfcheck4:
                if(check4.isChecked()){
                    check4.setChecked(false);
                }else {
                    check4.setChecked(true);
                }
                break;

        }
    }
}