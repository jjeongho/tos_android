package deu.cse.tos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BrushListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OralSuppliesAdapter oralSuppliesAdapter;
    private ArrayList<OralSupplies> items;
    private OralSupplies oralSupplies;
    private Intent nextIntent;
    private FloatingActionButton btn;
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
        setContentView(R.layout.activity_brushlist);
        btn =  findViewById(R.id.floatingActionButton);
        items = new ArrayList<>();
        oralSuppliesAdapter = new OralSuppliesAdapter(this, items, onClickItem);
        createRecyclerView();
        // OralSupplies 객체 생성
        items.add(new OralSupplies(38, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(39, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(40, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(41, "치약", "2020년 12월 25일"));
        items.add(new OralSupplies(42, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(45, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(49, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(34, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(38, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(12, "칫솔", "2020년 12월 25일"));
        items.add(new OralSupplies(190, "칫솔", "2020년 12월 25일"));
        oralSuppliesAdapter.notifyDataSetChanged();
        nextIntent = new Intent(this, AddBrushListActivity.class);

        btn.setOnClickListener((view)-> {
            startActivity(nextIntent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();

        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.


        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.actionbar, null);
        actionBar.setCustomView(actionbar);

        //액션바 양쪽 공백 없애기
        Toolbar parent = (Toolbar)actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);
        return true;
    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(BrushListActivity.this, v.getTag().toString(), Toast.LENGTH_SHORT).show();
            startActivity(nextIntent);
        }
    };

    private void createRecyclerView(){
        recyclerView = findViewById(R.id.rv_oral_supplies);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(oralSuppliesAdapter);
        recyclerView.setHasFixedSize(true);
    }
}
