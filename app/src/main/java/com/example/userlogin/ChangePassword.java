package com.example.userlogin;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
public class ChangePassword extends BaseActivity {
    private EditText changeuser;
    private EditText newpwd;
    private EditText mibao;
    private Button click;
    private Button back;
    private boolean Exists;
    private List<LoginData> loginData;
    private boolean panduan;
    private boolean mimapanding;
    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    private String data;
    private LoginData updata;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_new_password);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }
        changeuser = (EditText) findViewById(R.id.changeuser1);
        newpwd = (EditText) findViewById(R.id.newspwd);
        click = (Button) findViewById(R.id.changequeding);
        spinner = (Spinner) findViewById(R.id.miabao);
        mibao = (EditText) findViewById(R.id.mibaonei);
back=(Button)findViewById(R.id.btn_edit_back);
        data_list = new ArrayList<String>();
        data_list.add("点击选择密保问题");
        data_list.add("父母姓名");
        data_list.add("爱人姓名");
        data_list.add("幸运数字");
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arr_adapter);
        spinner.setSelection(0,true);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                data = arr_adapter.getItem(position);
                Toast.makeText(ChangePassword.this, "当前选择为"+data, Toast.LENGTH_SHORT).show();


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ChangePassword.this, "记得输入密保问题", Toast.LENGTH_SHORT).show();
            }
        });
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginData = DataSupport.select("user").find(LoginData.class);
                for (LoginData loginData1 : loginData) {

                    if (changeuser.getText().toString().trim().equals(loginData1.getUser()) ){
                        Exists = true;
                        break;
                    } else {
                        Exists = false;
                    }
                }
                if(!Exists){
                    Toast.makeText(ChangePassword.this, "账号不存在", Toast.LENGTH_SHORT).show();
                }

                if (Exists) {

                            if("父母姓名".equals(data)){
                                List<LoginData> par = DataSupport.select("parentname").where("user=?", changeuser.getText().toString()).find(LoginData.class);
                                for (LoginData pa:par) {
                                    if (mibao.getText().toString().trim().equals(pa.getParentname())){
                                        updata=new LoginData();
                                        updata.setPwd(newpwd.getText().toString());
                                        updata.updateAll("user=?",changeuser.getText().toString());
                                        Intent intent=new Intent(ChangePassword.this,MyUserLogin.class);
                                        startActivity(intent);
                                        Toast.makeText(ChangePassword.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                                        break;
                                    }else{
                                        Toast.makeText(ChangePassword.this, "密保输入错误", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            if("爱人姓名".equals(data)){
                                List<LoginData> par = DataSupport.select("lovename").where("user=?", changeuser.getText().toString()).find(LoginData.class);
                                for (LoginData pa:par) {
                                    if (mibao.getText().toString().trim().equals(pa.getLovename())){
                                        updata=new LoginData();
                                        updata.setPwd(newpwd.getText().toString());
                                        updata.updateAll("user=?",changeuser.getText().toString());
                                        Intent intent=new Intent(ChangePassword.this,MyUserLogin.class);
                                        startActivity(intent);
                                        Toast.makeText(ChangePassword.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                                        break;
                                    }else{
                                        Toast.makeText(ChangePassword.this, "密保输入错误", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            if("幸运数字".equals(data)){
                                List<LoginData> par = DataSupport.select("home").where("user=?", changeuser.getText().toString()).find(LoginData.class);
                                for (LoginData pa:par) {
                                    if (mibao.getText().toString().trim().equals(pa.getXingyunshuzi())){
                                        updata=new LoginData();
                                        updata.setPwd(newpwd.getText().toString());
                                        updata.updateAll("user=?",changeuser.getText().toString());
                                        Intent intent=new Intent(ChangePassword.this,MyUserLogin.class);
                                        startActivity(intent);
                                        Toast.makeText(ChangePassword.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                                        break;
                                    }else{
                                        Toast.makeText(ChangePassword.this, "密保输入错误", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }


                        }


                }


        });
    }
}


