package com.example.drivinglicense.adapter.dethi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivinglicense.databinding.ItemDethiBinding;
import com.example.drivinglicense.model.Licence;

import java.util.ArrayList;
import java.util.List;

public class AdapterDeThi extends RecyclerView.Adapter<AdapterDeThi.DeThiViewHolder> {

    private List<Licence> list = new ArrayList<>();

    public AdapterDeThi(List<Licence> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DeThiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DeThiViewHolder(ItemDethiBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DeThiViewHolder holder, int position) {
        if(position >=0 && position <10)
            holder.binding.testNumber.setText("0"+(position+1));
        else
            holder.binding.testNumber.setText(""+(position+1));
        holder.binding.title.setText("Đề Số "+(position+1));
        holder.binding.comment.setText("25 câu/19 phút");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DeThiViewHolder extends RecyclerView.ViewHolder {
        private ItemDethiBinding binding;
        public DeThiViewHolder(@NonNull ItemDethiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
