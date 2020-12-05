package deu.cse.tos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
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
    private Intent nextIntent;
    private FloatingActionButton btn;
    private Toolbar toolbar;
    private ActionBar actionBar;
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
        oralSuppliesAdapter.notifyDataSetChanged();
        nextIntent = new Intent(this, AddBrushListActivity.class);

        btn.setOnClickListener((view)-> {
            nextIntent.putExtra("remainingDate", "--");
            nextIntent.putExtra("itemName", "--");
            nextIntent.putExtra("recommendedDate", "--");
            startActivity(nextIntent);
        });
        initActionBar();
    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OralSupplies item  = oralSuppliesAdapter.getItem((int)v.getTag());
            nextIntent.putExtra("remainingDate", "--");
            nextIntent.putExtra("itemName", item.getItemName());
            nextIntent.putExtra("recommendedDate", "--");
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

    public void initActionBar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_customactionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                break;
            case R.id.account:
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
