package com.example.userlogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class UserMessageFragment extends Fragment {
   private RecyclerView myrecyclerview;
   private MessageAdapter adapter;
   private List<Message> recyclerdata=new ArrayList<>();


    @Override
    public void onStart() {
        recyclerdata.clear();
        addmessage();
        adapter=new MessageAdapter(recyclerdata);
        myrecyclerview.setAdapter(adapter);
        super.onStart();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.usermessage_fragment,container,false);
        addmessage();
        myrecyclerview=(RecyclerView)v.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        myrecyclerview.setLayoutManager(linearLayoutManager);
        adapter=new MessageAdapter(recyclerdata);
        myrecyclerview.setAdapter(adapter);
        return v;
    }
    public void addmessage(){

        StudentMessageDatabase database=new StudentMessageDatabase();
        List<StudentMessageDatabase> databaseList= DataSupport.findAll(StudentMessageDatabase.class);
        for (StudentMessageDatabase messageDatabase:databaseList) {
            Message a=new Message();
            a.setBanji(messageDatabase.getBanji());
            a.setXingbie(messageDatabase.getXingbie());
            a.setXingming(messageDatabase.getXingming());
            a.setXuehao(messageDatabase.getXuehao());
            recyclerdata.add(a);
        }
    }
}
