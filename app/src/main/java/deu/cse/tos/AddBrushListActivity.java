package deu.cse.tos;

import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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
    private TextView userName, itemName, usingDate;
    private Intent previousIntent;

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
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    //et.setText(new StringBuilder().append(year).append("-").append(monthOfYear + 1).append("-").append(dayOfMonth).append(" "));
                    et.setText(formatter.format(d));
                    long diff = new Date().getTime() - d.getTime();
                    usingDate.setText(Long.toString(diff/(24*60*60*1000)));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        userName = findViewById(R.id.tv_name);
        itemName = findViewById(R.id.tv_list_item_name);
        usingDate = findViewById(R.id.tv_date);
        et = findViewById(R.id.editTextDate);
        et.setTextIsSelectable(true);
        et.setShowSoftInputOnFocus(false);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        updateTextView();
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
                        itemName.setText(rb1.getTag().toString());
                        rb1.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case R.id.radioButton2:
                        itemName.setText(rb2.getTag().toString());
                        rb2.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case R.id.radioButton3:
                        itemName.setText(rb3.getTag().toString());
                        rb3.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case R.id.radioButton4:
                        itemName.setText(rb4.getTag().toString());
                        rb4.setTextColor(getResources().getColor(R.color.white));
                        break;
                }
            }
        });
    }
    public void updateTextView() {
        Intent previousIntent = getIntent();
        userName.setText("--");
        itemName.setText(previousIntent.getStringExtra("itemName"));
        usingDate.setText("--");
    }
}
