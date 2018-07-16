package com.example.userlogin;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.Calendar;
import java.util.List;

public class UserMseeage extends BaseActivity {
private TextView zhanghao;
private EditText yonghumingcheng;
private EditText jiatingzhuzhi;
private EditText shoujihaoma;
private TextView chushengriqi;
private TableRow chushengriqitr;
private EditText youxiang;
private Button back;
private Button start;
private String userzhnghao;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_mseeage);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }



        Intent intent=getIntent();
        userzhnghao=intent.getStringExtra("账号");
        chushengriqitr=(TableRow)findViewById(R.id.Uchushengnianyuetr);
        zhanghao=(TextView)findViewById(R.id.Uzhanghao);
        youxiang=(EditText)findViewById(R.id.Uyouxiang);
        yonghumingcheng=(EditText)findViewById(R.id.Uusermingcheng);
        jiatingzhuzhi=(EditText)findViewById(R.id.Ujiatingzhuzhi);
        shoujihaoma=(EditText)findViewById(R.id.Udianhua);
      chushengriqi=(TextView) findViewById(R.id.Uchushengnianyuetv);
      back=(Button)findViewById(R.id.Ufanhui);
      start=(Button)findViewById(R.id.Uqueding);
        List<LoginData> data= DataSupport.where("user=?",userzhnghao).find(LoginData.class);
        for (LoginData loginData:data){
            zhanghao.setText(loginData.getUser());
           yonghumingcheng.setText(loginData.getYonghumingcheng());
            jiatingzhuzhi.setText(loginData.getJiatingzhuzhi());
            chushengriqi.setText(loginData.getChushengnianyue());
           shoujihaoma.setText(loginData.getDianhuahaoma());
           youxiang.setText(loginData.getYouxiang());
        }
        chushengriqitr.setOnClickListener(new View.OnClickListener() {
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
                        chushengriqi.setText(days);
                    }
                };
                new DatePickerDialog(UserMseeage.this, onDateSetListener, mYear, mMonth, mDay).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginData shuju=new LoginData();
                shuju.setYonghumingcheng(yonghumingcheng.getText().toString());
                shuju.setDianhuahaoma(shoujihaoma.getText().toString().trim());
                shuju.setJiatingzhuzhi(jiatingzhuzhi.getText().toString().trim());
                shuju.setChushengnianyue(chushengriqi.getText().toString());
                shuju.setYouxiang(youxiang.getText().toString());
                shuju.updateAll("user=?",userzhnghao);
                Toast.makeText(UserMseeage.this, "修改信息成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
