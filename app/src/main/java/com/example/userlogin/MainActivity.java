package com.example.userlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends BaseActivity

        implements NavigationView.OnNavigationItemSelectedListener {
private String userzhanghao;
private TextView name;
private TextView youxiang;
private String mima;
private int id;
private int id1;
public static String caozuoquanxian;
    @Override


    protected void onStart() {
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        View headview=navigationView.getHeaderView(0);
        name=(TextView)headview.findViewById(R.id.headname);
        youxiang=(TextView)headview.findViewById(R.id.headyouxiang);

        List<LoginData> data111= DataSupport.where("user=?",userzhanghao).find(LoginData.class);
        for (LoginData loginData1:data111){
            mima=loginData1.getPwd();
            name.setText(loginData1.getYonghumingcheng());
            youxiang.setText(loginData1.getYouxiang());
            break;
        }
        super.onStart();
    }






    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent=getIntent();//传递数据
        userzhanghao=intent.getStringExtra("账号");


//级联查询
        List<LoginData> a=DataSupport.where("user=?",userzhanghao).find(LoginData.class);
        for(LoginData a1:a){
            id=a1.getId();
            break;
        }
        Log.d("caozuoquanxian", "onCreate: "+id);
        LoginData loginData=DataSupport.find(LoginData.class,id,true);
User_Roll user_rolls=loginData.getUser_roll();
id1=user_rolls.getId();
        Log.d("caozuoquanxian", "onCreate: "+id1);
        User_Roll user_roll=DataSupport.find(User_Roll.class,id1,true);
List<RollDatabase>rollDatabases=user_roll.getRollDatabases();
       for(RollDatabase rollData:rollDatabases){
           Log.d("caozuoquanxian", "onCreate: "+rollData.getRoll_Administrator());
           Log.d("caozuoquanxian", "onCreate: "+rollData.getRoll_User());
         if(rollData.getRoll_User()!=null) {
             caozuoquanxian = rollData.getRoll_User();
         }
            else {   caozuoquanxian=rollData.getRoll_Administrator();}

       }


        Log.d("caozuoquanxian", "onCreate: "+caozuoquanxian);
NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        if ("普通用户".equals(caozuoquanxian)) {
navigationView.getMenu().removeItem(R.id.nav_gallery);
navigationView.getMenu().removeItem(R.id.nav_manage);}
View headview=navigationView.getHeaderView(0);




name=(TextView)headview.findViewById(R.id.headname);
youxiang=(TextView)headview.findViewById(R.id.headyouxiang);

        List<LoginData> data111= DataSupport.where("user=?",userzhanghao).find(LoginData.class);
        if(data111.size()==0){
        for (LoginData loginData1:data111){
          name.setText(loginData1.getYonghumingcheng());
          youxiang.setText(loginData1.getYouxiang());
          break;
        }}else {
            name.setText("");
            youxiang.setText("");
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            List<StudentMessageDatabase>databaseList=DataSupport.findAll(StudentMessageDatabase.class);
            Toast.makeText(this, "当前学生总数为"+databaseList.size()+"人", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent1=new Intent(MainActivity.this,FindMseeage.class);
            intent1.putExtra("账号",userzhanghao);
            startActivity(intent1);

        } else if (id == R.id.nav_gallery) {
            Intent intent1=new Intent(MainActivity.this,StudentRegisterMseeage.class);
            intent1.putExtra("账号",userzhanghao);
            startActivity(intent1);
        } else if (id == R.id.nav_slideshow) {
Intent intent=new Intent(this,StudentINFO.class);
            intent.putExtra("账号",userzhanghao);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            Intent intent1=new Intent(MainActivity.this,UpdataMseeage.class);
            intent1.putExtra("账号",userzhanghao);
            startActivity(intent1);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.nav_exit) {
            ActivityCollector.finishAll();
            Intent intent=new Intent(MainActivity.this,MyUserLogin.class);
            intent.putExtra("账号",userzhanghao);
            intent.putExtra("密码",mima);
            startActivity(intent);
        }else if (id==R.id.nav_xiugai){
Intent intent=new Intent(MainActivity.this,Passwordchange.class);
            intent.putExtra("账号",userzhanghao);
            startActivity(intent);
        }else if(id==R.id.nav_exitall){
            ActivityCollector.finishAll();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void click(View view){
       Intent intent=new Intent(this,UserMseeage.class);
       intent.putExtra("账号",userzhanghao);
       startActivity(intent);
    }

}
