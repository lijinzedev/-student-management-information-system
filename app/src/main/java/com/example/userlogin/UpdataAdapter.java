package com.example.userlogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UpdataAdapter extends RecyclerView.Adapter<UpdataAdapter.ViewHolder> {
    private List<Message> mymessages;
    public UpdataAdapter(List<Message>mymessages){
        this.mymessages=mymessages;
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_base_swipe_list,parent,false);
        final ViewHolder holder=new ViewHolder(v);
        holder.mseeageadapterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int possition=holder.getAdapterPosition();//获取当前点击实例
                final Message the=mymessages.get(possition);//加载当前点击数据
                //使用自定的活动开启方法用于传递数据
                StudentDetails.actionstart(v.getContext(),the.getXuehao(),the.getBanji(),the.getXingming(),the.getXingbie());

            }
        });
        return holder;
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//为item加载数据
        Message message=mymessages.get(position);
        holder.banji.setText(message.getBanji());
        holder.xingming.setText(message.getXingming());
        holder.xuehao.setText(message.getXuehao());
        holder.xingbie.setText(message.getXingbie());
    }

    public int getItemCount() {
        return mymessages.size();
    }
    public static   class ViewHolder extends RecyclerView.ViewHolder {//缓冲器加快运行速度
        private  View mseeageadapterview;
        private TextView xingming;
        private TextView xuehao;
        private TextView xingbie;
        private TextView banji;
        public ViewHolder(View view) {
            super(view);
            mseeageadapterview=view;
            xingming=(TextView)view.findViewById(R.id.xingming);
            xingbie=(TextView)view.findViewById(R.id.xingbie);
            xuehao=(TextView)view.findViewById(R.id.xuehao);
            banji=(TextView)view.findViewById(R.id.banji);
        }
    }
}
