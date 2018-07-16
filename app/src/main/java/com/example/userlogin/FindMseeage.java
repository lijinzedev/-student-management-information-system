package com.example.userlogin;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.LitePalDB;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class FindMseeage extends BaseActivity {
    private RecyclerView recyclerview;
    private MessageAdapter adapter;
    private List<Message> recyclerdata=new ArrayList<>();
    private Button find_start;
 private EditText find_mesage;
 private Button cancle;
 private String findmessage;
 private boolean a;
 private   String userzhanghao;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean panding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_mseeage);



        Intent intent=getIntent();//传递数据
        userzhanghao=intent.getStringExtra("账号");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }
       find_mesage=(EditText)findViewById(R.id.et_search);
       cancle=(Button)findViewById(R.id.find_cancle);
       find_start=(Button)findViewById(R.id.find);
        recyclerview=(RecyclerView)findViewById(R.id.find_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        adapter=new MessageAdapter(recyclerdata);
        recyclerview.setAdapter(adapter);
     find_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerdata.clear();
                findmessage=find_mesage.getText().toString().trim();//获取当前搜索框内容
                List<StudentMessageDatabase>data= DataSupport.where("xingming=?",findmessage).find(StudentMessageDatabase.class);
                if (data.size()!=0){
                    a=true;
                for(StudentMessageDatabase message:data){
                    Message news=new Message();
                    news.setXuehao(message.getXuehao());
                    news.setXingming(message.getXingming());
                    news.setXingbie(message.getXingbie());
                    news.setBanji(message.getBanji());
                    recyclerdata.add(news);
                    adapter.notifyDataSetChanged();
                    recyclerview.scrollToPosition(recyclerdata.size()-1);

                }return;}else{        a=false;
                }
                List<StudentMessageDatabase>data1= DataSupport.where("xuehao=?",findmessage).find(StudentMessageDatabase.class);
                if(data1.size()!=0){
                    b=true;
                for(StudentMessageDatabase message:data1){
                    adapter.notifyDataSetChanged();
                    Message news=new Message();
                    news.setXuehao(message.getXuehao());
                    news.setXingming(message.getXingming());
                    news.setXingbie(message.getXingbie());
                    news.setBanji(message.getBanji());
                    recyclerdata.add(news);
                    adapter.notifyDataSetChanged();
                    recyclerview.scrollToPosition(recyclerdata.size()-1);

                }return;}else {                   b=false;
                }
                List<StudentMessageDatabase>data2= DataSupport.where("xingbie=?",findmessage).find(StudentMessageDatabase.class);
                if (data2.size()!=0){
                    c=true;
                for(StudentMessageDatabase message:data2){

                    Message news=new Message();
                    news.setXuehao(message.getXuehao());
                    news.setXingming(message.getXingming());
                    news.setXingbie(message.getXingbie());
                    news.setBanji(message.getBanji());
                    recyclerdata.add(news);
                    adapter.notifyDataSetChanged();
                    recyclerview.scrollToPosition(recyclerdata.size()-1);

                }
                    return;
                }else {
                  c=false;
                }
                List<StudentMessageDatabase>data4= DataSupport.where("xingming like ?","%"+findmessage+"%").find(StudentMessageDatabase.class);
                if (data4.size()!=0){
                    e=true;
                    for(StudentMessageDatabase message:data4){

                        Message news=new Message();
                        news.setXuehao(message.getXuehao());
                        news.setXingming(message.getXingming());
                        news.setXingbie(message.getXingbie());
                        news.setBanji(message.getBanji());
                        recyclerdata.add(news);
                        adapter.notifyDataSetChanged();
                        recyclerview.scrollToPosition(recyclerdata.size()-1);

                    }
                    return;
                }else {
                    e=false;
                }
                List<StudentMessageDatabase>data3= DataSupport.where("banji=?",findmessage).find(StudentMessageDatabase.class);
                if(data3.size()!=0){
                    d=true;
                for(StudentMessageDatabase message:data3){
                    recyclerdata.clear();
                    adapter.notifyDataSetChanged();
                    Message news=new Message();
                    news.setXuehao(message.getXuehao());
                    news.setXingming(message.getXingming());
                    news.setXingbie(message.getXingbie());
                    news.setBanji(message.getBanji());
                    recyclerdata.add(news);
                    adapter.notifyDataSetChanged();
                    recyclerview.scrollToPosition(recyclerdata.size()-1);

                }
                    return;
                }
                else {                  d=false;
                }
                List<StudentMessageDatabase>data5= DataSupport.where("xuehao like ?","%"+findmessage+"%").find(StudentMessageDatabase.class);
                if (data5.size()!=0){
                    g=true;
                    for(StudentMessageDatabase message:data5){

                        Message news=new Message();
                        news.setXuehao(message.getXuehao());
                        news.setXingming(message.getXingming());
                        news.setXingbie(message.getXingbie());
                        news.setBanji(message.getBanji());
                        recyclerdata.add(news);
                        adapter.notifyDataSetChanged();
                        recyclerview.scrollToPosition(recyclerdata.size()-1);

                    }
                    return;
                }else {
                    g=false;
                }
                List<StudentMessageDatabase>data6= DataSupport.where("jiguan like ?","%"+findmessage+"%").find(StudentMessageDatabase.class);
                if (data6.size()!=0){
                    h=true;
                    for(StudentMessageDatabase message:data6){

                        Message news=new Message();
                        news.setXuehao(message.getXuehao());
                        news.setXingming(message.getXingming());
                        news.setXingbie(message.getXingbie());
                        news.setBanji(message.getBanji());
                        recyclerdata.add(news);
                        adapter.notifyDataSetChanged();
                        recyclerview.scrollToPosition(recyclerdata.size()-1);

                    }
                    return;
                }else {
                    h=false;
                }
                List<StudentMessageDatabase>data7= DataSupport.where("dianhua like ?","%"+findmessage+"%").find(StudentMessageDatabase.class);
                if (data7.size()!=0){
                    i=true;
                    for(StudentMessageDatabase message:data7){

                        Message news=new Message();
                        news.setXuehao(message.getXuehao());
                        news.setXingming(message.getXingming());
                        news.setXingbie(message.getXingbie());
                        news.setBanji(message.getBanji());
                        recyclerdata.add(news);
                        adapter.notifyDataSetChanged();
                        recyclerview.scrollToPosition(recyclerdata.size()-1);

                    }
                    return;
                }else {
                    i=false;
                }
                List<StudentMessageDatabase>data8= DataSupport.where("zhuanye like ?","%"+findmessage+"%").find(StudentMessageDatabase.class);
                if (data8.size()!=0){
                    j=true;
                    for(StudentMessageDatabase message:data8){

                        Message news=new Message();
                        news.setXuehao(message.getXuehao());
                        news.setXingming(message.getXingming());
                        news.setXingbie(message.getXingbie());
                        news.setBanji(message.getBanji());
                        recyclerdata.add(news);
                        adapter.notifyDataSetChanged();
                        recyclerview.scrollToPosition(recyclerdata.size()-1);

                    }
                    return;
                }else {
                    j=false;
                }
                panding=a||b||c||d||e||g||h||i;
                if(!panding){
                    Toast.makeText(FindMseeage.this, "信息不存在", Toast.LENGTH_SHORT).show();

                }
            }
       });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindMseeage.this,MainActivity.class);
                intent.putExtra("账号",userzhanghao);
                startActivity(intent);
                finish();
            }
        });
    }
}
