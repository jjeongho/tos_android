package deu.cse.tos;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddBrushListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OralSuppliesAdapter oralSuppliesAdapter;
    private ArrayList<OralSupplies> items;
    private OralSupplies oralSupplies;
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
    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Toast.makeText(AddBrushListActivity.this, v.getTag().toString(), Toast.LENGTH_SHORT).show();
        }
    };

    private void createRecyclerView(){
        recyclerView = findViewById(R.id.rv_oral_supplies);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(oralSuppliesAdapter);
    }
}
