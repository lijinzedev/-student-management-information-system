package com.example.userlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class UpdataMseeage extends BaseActivity {
    private RecyclerView myrecyclerview;
    private UpdataAdapter adapter;
    private List<Message> recyclerdata=new ArrayList<>();
    private Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updata_mseeage);
        addmessage();
        button=(Button)findViewById(R.id.cancle);
        myrecyclerview=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        myrecyclerview.setLayoutManager(linearLayoutManager);
        adapter=new UpdataAdapter(recyclerdata);
        myrecyclerview.setAdapter(adapter);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
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
