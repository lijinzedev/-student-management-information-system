package com.example.userlogin;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Passwordchange extends BaseActivity {
    private Button click;
    private Button back;
    private String mima;
    private EditText oldpwd;
    private EditText newpwd;
    private String zhanghao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_change);
         Intent intent=getIntent();
        zhanghao=intent.getStringExtra("账号");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }
        back=(Button)findViewById(R.id.Xbtn_edit_back);
        click = (Button) findViewById(R.id.Xchangequeding);
        oldpwd=(EditText) findViewById(R.id.Xoldpwd);
        newpwd=(EditText)findViewById(R.id.Xnewspwd);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginData data=new LoginData();
                List<LoginData>dataList= DataSupport.where("user=?",zhanghao).find(LoginData.class);
                for (LoginData a:dataList){
                   mima= a.getPwd();
                   break;
                }
                if (oldpwd.getText().toString().trim().equals(mima)){
                    data.setPwd(newpwd.getText().toString().trim());
                    data.updateAll("user=?",zhanghao);
                    Toast.makeText(Passwordchange.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                    Intent intent1=new Intent(Passwordchange.this,MyUserLogin.class);
                    intent1.putExtra("账号",zhanghao);
                    intent1.putExtra("密码","");
                    startActivity(intent1);
                    ActivityCollector.finishAll();
                }else {
                    Toast.makeText(Passwordchange.this, "密码错误请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
