package com.example.userlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginSuccessd extends AppCompatActivity {
private Button select;
    private Button update;
    private Button addto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_successd);
        addto=(Button)findViewById(R.id.tinajiaxuehsengxinxi);
        select=(Button)findViewById(R.id.chaxunxueshengxinxi);
        update=(Button)findViewById(R.id.xiugaixueshengxinxi);
        addto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSuccessd.this,StudentRegisterMseeage.class);
                startActivity(intent);
                finish();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSuccessd.this,UpdataMseeage.class);
                startActivity(intent);
                finish();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSuccessd.this,FindMseeage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
