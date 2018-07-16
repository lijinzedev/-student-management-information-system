package com.example.userlogin;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import java.util.List;
public class MyUserLogin extends BaseActivity {
    private Button button;
    private List<LoginData>loginData;
    private boolean Exists;
    private EditText myuser;
    private EditText mypwd;
    private Button login;
    private Button xiugai;
    private boolean panduan;
private String zhanghao;
private String mima;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginnews);
        LitePal.getDatabase();


        Intent intent=getIntent();
        zhanghao=intent.getStringExtra("账号");
        mima=intent.getStringExtra("密码");

        button=(Button) findViewById(R.id.zhuce) ;
        login=(Button) findViewById(R.id.login) ;
        myuser = (EditText) findViewById(R.id.user);
        mypwd = (EditText) findViewById(R.id.pwd);
        xiugai=(Button) findViewById(R.id.xiugai) ;
myuser.setText(zhanghao);
mypwd.setText(mima);

xiugai.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MyUserLogin.this,ChangePassword.class);
        startActivity(intent);
    }
});
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyUserLogin.this,MyRegister.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginData = DataSupport.select("user")
                        .find(LoginData.class);
                for (LoginData loginData1 : loginData) {

                    if (myuser.getText().toString().trim().equals(loginData1.getUser())) {
                        Exists = true;
                        break;
                    } else {
                        Exists = false;
                    }
                }
                if(!Exists){
                    Toast.makeText(MyUserLogin.this, "账号不存在", Toast.LENGTH_SHORT).show();
                }
                if(Exists) {
                    List<LoginData> pwdlist = DataSupport.select("pwd")
                            .where("user=?", myuser.getText().toString())
                            .find(LoginData.class);
                    for (LoginData mypwd1 : pwdlist)
                        if (mypwd1.getPwd().equals(mypwd.getText().toString().trim()) && !mypwd1.getPwd().isEmpty()) {
                            Intent intent = new Intent(MyUserLogin.this, MainActivity.class);
                            intent.putExtra("账号",myuser.getText().toString().trim());
                            startActivity(intent);
                            finish();
                            panduan=false;
                        }
                        else {panduan=true;}
                        if(panduan){
                        Toast.makeText(MyUserLogin.this, "密码错误", Toast.LENGTH_SHORT).show();}

                }
                }
            });
        }

    }

