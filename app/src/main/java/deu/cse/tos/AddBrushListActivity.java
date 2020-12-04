package deu.cse.tos;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBrushListActivity extends AppCompatActivity {
    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup rg;


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
        setContentView(R.layout.activity_addbrushlist);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                rb2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                rb3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                rb4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                switch (i){
                    case R.id.radioButton1:
                        Toast.makeText(AddBrushListActivity.this, rb1.getTag().toString(), Toast.LENGTH_LONG).show();
                        rb1.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(AddBrushListActivity.this, rb2.getTag().toString(), Toast.LENGTH_LONG).show();
                        rb2.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(AddBrushListActivity.this, rb3.getTag().toString(), Toast.LENGTH_LONG).show();
                        rb3.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case R.id.radioButton4:
                        Toast.makeText(AddBrushListActivity.this, rb4.getTag().toString(), Toast.LENGTH_LONG).show();
                        rb4.setTextColor(getResources().getColor(R.color.white));
                        break;
                }
            }
        });
    }
}
