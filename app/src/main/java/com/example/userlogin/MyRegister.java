package com.example.userlogin;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyRegister extends BaseActivity {
    private EditText user;
    private EditText pwd;
    private EditText pwd2;
    private EditText jiatingzhuzhi;
    private EditText youxiang;
    private EditText dianhuahaoma;
    private EditText yonghumingcheng;
    private TextView chushengnianyue;
    private TextView shenfen;
    private TableRow Rshenfen;
    private Button button;
    private Button back;
    private EditText mibao;
    private List<LoginData> registers;
    private boolean panding=true;
    private boolean mimapanding;
    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
private LoginData logindata;
private String data;
private TableRow chushengnianyuetr;
private RollDatabase rollDatabase;
private  User_Roll user_roll;
    private String[] sexArry = new String[]{ "普通用户", "管理员用户"};// 权限选择
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registernews);
        user_roll=new User_Roll();
        LitePal.getDatabase();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }
        shenfen=(TextView)findViewById(R.id.shenfen);
        Rshenfen=(TableRow)findViewById(R.id.Rshenfen);
        dianhuahaoma=(EditText)findViewById(R.id.rdianhuahaoma);
        user = (EditText) findViewById(R.id.user1);
        yonghumingcheng=(EditText)findViewById(R.id.Uyonghumingcheng);
        pwd = (EditText) findViewById(R.id.pwd1);
        pwd2 = (EditText) findViewById(R.id.pwd2);
        mibao = (EditText) findViewById(R.id.mibaoneirong);
        button = (Button) findViewById(R.id.queding);
        back=(Button)findViewById(R.id.btn_edit_back);
        spinner = (Spinner) findViewById(R.id.miabao);
        jiatingzhuzhi=(EditText)findViewById(R.id.jiatingzhuzhi);
        youxiang=(EditText)findViewById(R.id.youxiang);
        chushengnianyue=(TextView)findViewById(R.id.chushengnianyeutv);
chushengnianyuetr=(TableRow)findViewById(R.id.chushengnianyuetr);
Rshenfen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder tishi=new AlertDialog.Builder(MyRegister.this);

                tishi.setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       shenfen.setText(sexArry[which]);
                      rollDatabase=new RollDatabase();
                        if("管理员用户".equals(shenfen.getText().toString())){
                        rollDatabase.setRoll_Administrator(shenfen.getText().toString());}
                        else {rollDatabase.setRoll_User(shenfen.getText().toString());}
                        rollDatabase.save();
                        user_roll.getRollDatabases().add(rollDatabase);
                        dialog.dismiss();
                    }
                });
                tishi.show();
            }
        });
chushengnianyuetr.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Calendar nowdate = Calendar.getInstance();
        int mYear = nowdate.get(Calendar.YEAR);
        int mMonth = nowdate.get(Calendar.MONTH);
        int mDay = nowdate.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int mYear = year;
                int mMonth = month;
                int mDay = dayOfMonth;
                String days;
                days = new StringBuffer().append(mYear).append("年").append(mMonth).append("月").append(mDay).append("日").toString();
                chushengnianyue.setText(days);
            }
        };
        new DatePickerDialog(MyRegister.this, onDateSetListener, mYear, mMonth, mDay).show();
    }
});
        data_list = new ArrayList<String>();
        data_list.add("点击选择密保问题");
        data_list.add("父母姓名");
        data_list.add("爱人姓名");
        data_list.add("幸运数字");
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setSelection(1,true);
        spinner.setAdapter(arr_adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  data = arr_adapter.getItem(position);

                }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MyRegister.this, "记得输入密保问题", Toast.LENGTH_SHORT).show();
            }
        });

back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registers = DataSupport.select("user").find(LoginData.class);
                for (LoginData loginData1 : registers) {
                    if (user.getText().toString().equals(loginData1.getUser()) ){
                        Toast.makeText(MyRegister.this, "账号存在请重新输入", Toast.LENGTH_SHORT).show();
                        user.setText("");
                        panding=false;
                        break;
                    }
                    else {
                        panding=true;
                    }
                }
                if (pwd.getText().toString().trim().equals(pwd2.getText().toString().trim())){
                    mimapanding=true;
                }
                else {mimapanding=false;
                    Toast.makeText(MyRegister.this, "两次与密码输入不同请重新输入", Toast.LENGTH_SHORT).show();
                }
if(panding&&mimapanding) {
    logindata = new LoginData();
    logindata.setUser(user.getText().toString().trim());
    logindata.setPwd(pwd.getText().toString().trim());
    logindata.setYonghumingcheng(yonghumingcheng.getText().toString());
    logindata.setJiatingzhuzhi(jiatingzhuzhi.getText().toString().trim());
    logindata.setYouxiang(youxiang.getText().toString().trim());
    logindata.setChushengnianyue(chushengnianyue.getText().toString());
    logindata.setDianhuahaoma(dianhuahaoma.getText().toString());
    if(data.equals("父母姓名")){
        logindata.setParentname(mibao.getText().toString().trim());
    }
    if(data.equals("爱人姓名")){
        logindata.setLovename(mibao.getText().toString().trim());

    }
    if(data.equals("幸运数字")){
        logindata.setXingyunshuzi(mibao.getText().toString().trim());

    }
    logindata.save();
    user_roll.getLoginData().add(logindata);

    user_roll.save();
    Toast.makeText(MyRegister.this, "注册成功", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(MyRegister.this, MyUserLogin.class);
    startActivity(intent);
    finish();
}

            }
        });
    }
}


