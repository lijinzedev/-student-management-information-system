package com.example.userlogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
private List<Message>mymessages;
private String yonghuquanxian;
public MessageAdapter(List<Message>mymessages){
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

holder.mseeageadapterview.setOnLongClickListener(new View.OnLongClickListener() {
    @Override

    public boolean onLongClick(View v) {

        final int possition=holder.getAdapterPosition();
        final Message the=mymessages.get(possition);
        yonghuquanxian=MainActivity.caozuoquanxian;
        AlertDialog.Builder tishi=new AlertDialog.Builder(v.getContext());
        tishi.setTitle("信息处理");
        tishi.setMessage("您确定要删除这个条学生信息吗");
        tishi.setCancelable(false);
        tishi.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mymessages.remove(possition);
                notifyItemRemoved(possition);
                notifyItemRangeChanged(0,mymessages.size());
                DataSupport.deleteAll(StudentMessageDatabase.class,"xuehao=?",the.getXuehao());

            }
        });
        tishi.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }); if ("管理员用户".equals(yonghuquanxian)){
        tishi.show();}
        return true;
    }
});
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
Message message=mymessages.get(position);
holder.banji.setText(message.getBanji());
holder.xingming.setText(message.getXingming());
holder.xuehao.setText(message.getXuehao());
holder.xingbie.setText(message.getXingbie());
    }

    @Override
    public int getItemCount() {
        return mymessages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
