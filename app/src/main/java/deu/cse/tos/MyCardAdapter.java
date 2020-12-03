package deu.cse.tos;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyCardAdapter extends RecyclerView.Adapter<MyCardAdapter.ViewHolder> {
    private ArrayList<QnAList> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    public MyCardAdapter(Context context, ArrayList<QnAList> itemList, View.OnClickListener onClickItem) {
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // context 와 parent.getContext() 는 같다.
        View view = LayoutInflater.from(context)
                .inflate(R.layout.card_tv, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        QnAList item = itemList.get(position);

        holder.question_tv.setText(item.getQuestion());
        holder.question_tv.setTag(item);
        holder.question_tv.setOnClickListener(onClickItem);

        holder.answer_tv.setText(item.getAnswer());
        holder.answer_tv.setTag(item);
        holder.answer_tv.setOnClickListener(onClickItem);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView answer_tv;
        public TextView question_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            answer_tv = itemView.findViewById(R.id.tv_question);
            question_tv = itemView.findViewById(R.id.tv_answer);
        }
    }
}
