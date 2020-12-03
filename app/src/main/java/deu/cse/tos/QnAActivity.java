package deu.cse.tos;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QnAActivity extends AppCompatActivity {
    private Context mContext = QnAActivity.this;
    private static final int ACTIVITY_NUM = 1;
    private static final String TAG = "QnAActivity";
    private RecyclerView recyclerView;
    private MyHashAdapter hashAdapter;
    private MyCardAdapter cardAdapter;

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
        setContentView(R.layout.activity_qna);
<<<<<<< HEAD

=======
>>>>>>> main
        initHashTag();
        initCard();
    }

    private void initHashTag(){
        recyclerView = findViewById(R.id.hashtag);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("0");
        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");
        itemList.add("5");
        itemList.add("6");
        itemList.add("7");
        itemList.add("8");
        itemList.add("9");
        itemList.add("10");
        itemList.add("testing~~~");

        hashAdapter = new MyHashAdapter(this, itemList, onClickItem);
        recyclerView.setAdapter(hashAdapter);
<<<<<<< HEAD

        MyListDecoration decoration = new MyListDecoration();
        recyclerView.addItemDecoration(decoration);
    }

    private void initCard(){
        recyclerView = findViewById(R.id.card);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<QnAList> itemList = new ArrayList<>();
        itemList.add(new QnAList("q1", "a1"));
        itemList.add(new QnAList("q2", "a2"));
        itemList.add(new QnAList("q3", "a3"));
        itemList.add(new QnAList("q4", "a4"));
        itemList.add(new QnAList("q5", "a5"));

        cardAdapter = new MyCardAdapter(this, itemList, onClickItem);
        recyclerView.setAdapter(cardAdapter);

        MyListDecoration decoration = new MyListDecoration();
        recyclerView.addItemDecoration(decoration);
=======

        MyListDecoration decoration = new MyListDecoration();
        recyclerView.addItemDecoration(decoration);
    }

    private void initCard(){
        recyclerView = findViewById(R.id.card);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<QnAList> itemList = new ArrayList<>();
        itemList.add(new QnAList("q1", "a1"));
        itemList.add(new QnAList("q2", "a2"));
        itemList.add(new QnAList("q3", "a3"));
        itemList.add(new QnAList("q4", "a4"));
        itemList.add(new QnAList("q5", "a5"));

        cardAdapter = new MyCardAdapter(this, itemList, onClickItem);
        recyclerView.setAdapter(cardAdapter);

        MyListDecoration decoration = new MyListDecoration();
        recyclerView.addItemDecoration(decoration);
>>>>>>> main
    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(QnAActivity.this, str, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QnAActivity.this, ShowQnAActivity.class);
            startActivity(intent);
        }
    };

<<<<<<< HEAD
=======


>>>>>>> main
}