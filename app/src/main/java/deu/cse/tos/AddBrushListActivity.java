package deu.cse.tos;

import android.app.DatePickerDialog;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddBrushListActivity extends AppCompatActivity {
    private RadioButton rb1, rb2, rb3, rb4;
    private RadioGroup rg;
    private EditText et;
    private DatePickerDialog datePickerDialog;
    private int mYear, mMonth, mDay;

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

        Calendar c = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(AddBrushListActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                try {
                    Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    et.setText(new StringBuilder().append(year).append("-").append(monthOfYear + 1).append("-").append(dayOfMonth).append(" "));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        et = findViewById(R.id.editTextDate);
        et.setTextIsSelectable(true);
        et.setShowSoftInputOnFocus(false);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                rb2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                rb3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                rb4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                switch (i) {
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
