package deu.cse.tos;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QnAFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final int ACTIVITY_NUM = 1;
    private static final String TAG = "QnAActivity";
    private RecyclerView recyclerView;
    private MyHashAdapter hashAdapter;
    private MyCardAdapter cardAdapter;
    private Context context;
    private Intent intent;
    private Intent qnaIntent;

    private ArrayList<String> hashList = new ArrayList<>();
    private ArrayList<QnAList> qnaList = new ArrayList<>();

    public QnAFragment() {
        // Required empty public constructor
    }
    private void initActivity() {
        // MAIN SET UP Navigation Bar & Status Bar
        Window window = getActivity().getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0x00000000);  // transparent
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.addFlags(flags);
        }
        View decorView = getActivity().getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initActivity();
        this.intent = new Intent(getActivity(), ShowQnAActivity.class);
        this.qnaIntent = new Intent(getActivity(), ShowQnAActivity.class);
        this.context = container.getContext();
        return inflater.inflate(R.layout.fragment_qna, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initHashTag(view);
        initCard(view);
    }

    private void initHashTag(View view){
        recyclerView = view.findViewById(R.id.hashtag);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        hashList.add("0");
        hashList.add("1");
        hashList.add("2");
        hashList.add("3");
        hashList.add("4");
        hashList.add("5");
        hashList.add("6");
        hashList.add("7");
        hashList.add("8");
        hashList.add("9");
        hashList.add("10");
        hashList.add("testing~~~");

        hashAdapter = new MyHashAdapter(this.context, hashList, onClickHash);
        recyclerView.setAdapter(hashAdapter);

        MyListDecoration decoration = new MyListDecoration();
        recyclerView.addItemDecoration(decoration);
    }

    private void initCard(View view){
        recyclerView = view.findViewById(R.id.card);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        qnaList.add(new QnAList("q1", "a1"));
        qnaList.add(new QnAList("q2", "a2"));
        qnaList.add(new QnAList("q3", "a3"));
        qnaList.add(new QnAList("q4", "a4"));
        qnaList.add(new QnAList("q5", "a5"));

        cardAdapter = new MyCardAdapter(this.context, qnaList);
        recyclerView.setAdapter(cardAdapter);

        MyListDecoration decoration = new MyListDecoration();
        recyclerView.addItemDecoration(decoration);
    }

    private View.OnClickListener onClickHash = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

            startActivity(intent);
        }
    };

    private CardView.OnClickListener onClickQnA = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

//            qnaIntent.putExtra("question", str);
//            startActivity(qnaIntent);
        }
    };

}