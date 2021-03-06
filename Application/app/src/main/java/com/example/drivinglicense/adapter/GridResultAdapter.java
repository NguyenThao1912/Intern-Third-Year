package com.example.drivinglicense.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivinglicense.R;
import com.example.drivinglicense.global.AppGlobal;
import com.example.drivinglicense.model.CurrentQuestion;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.List;

public class GridResultAdapter extends RecyclerView.Adapter<GridResultAdapter.MyViewHolder> {

    Context context;
    List<CurrentQuestion> currentQuestionList;

    public GridResultAdapter(Context context, List<CurrentQuestion> currentQuestionList) {
        this.context = context;
        this.currentQuestionList = currentQuestionList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_result_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Drawable img;

        holder.btn_question.setText(new StringBuilder("Question").append(currentQuestionList.get(position).getQuestionIndex() + 1));
        if (currentQuestionList.get(position).getType() == AppGlobal.ANSWER_TYPE.RIGHT_ANSWER) {
            holder.btn_question.setBackgroundColor(Color.parseColor("#ff99cc00"));
            img = context.getResources().getDrawable(R.drawable.ic_baseline_check_white);
            holder.btn_question.setCompoundDrawablesWithIntrinsicBounds(null, null, null, img);
        } else if (currentQuestionList.get(position).getType() == AppGlobal.ANSWER_TYPE.WRONG_ANSWER) {
            holder.btn_question.setBackgroundColor(Color.parseColor("#ff99cc00"));
            img = context.getResources().getDrawable(R.drawable.ic_baseline_clear_white);
            holder.btn_question.setCompoundDrawablesWithIntrinsicBounds(null, null, null, img);
        } else {
            holder.btn_question.setBackgroundColor(Color.parseColor("#ff99cc00"));
            img = context.getResources().getDrawable(R.drawable.ic_baseline_error_outline_white);
            holder.btn_question.setCompoundDrawablesWithIntrinsicBounds(null, null, null, img);
        }
    }

    @Override
    public int getItemCount() {
        return currentQuestionList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        Button btn_question;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_question = itemView.findViewById(R.id.btn_question);
            btn_question.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LocalBroadcastManager.getInstance(context)
                            .sendBroadcast(new Intent(AppGlobal.KEY_BACK_FROM_RESULT).putExtra(AppGlobal.KEY_BACK_FROM_RESULT
                                    , currentQuestionList.get(getAdapterPosition()).getQuestionIndex()));
                }
            });
        }
    }
}
