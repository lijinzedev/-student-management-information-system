package com.example.userlogin;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
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

public class StudentRegisterMseeage extends BaseActivity {
    private boolean xuehaoesists;//学号判断符
private EditText xingming;     //注册输入框
private EditText xuehao;
private EditText banji;
private TextView xingbie;
private EditText zhuanye;
private EditText dianhua;
private EditText jiguan;
    private TextView shengri;
private Button queding;
private Button resgint_back;
    private TableRow tr_edit_birth;        //生日选择
    private  TableRow trBirth;           //性别选择
    private String[] sexArry = new String[]{ "女", "男"};// 性别选择
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_register_mseeage);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }
        trBirth = (TableRow) findViewById(R.id.tr_edit_gender);
        tr_edit_birth=(TableRow)findViewById(R.id.Strshengri);
        shengri=(TextView)findViewById(R.id.Stvshengri) ;
        resgint_back=(Button)findViewById(R.id.Sback);
        zhuanye=(EditText)findViewById(R.id.Szhuanye);
        dianhua=(EditText)findViewById(R.id.Sshouji);
        jiguan=(EditText)findViewById(R.id.Sjiguan);
        xingming=(EditText)findViewById(R.id.Sxingming);
        xuehao=(EditText)findViewById(R.id.Sxuehao);
        xingbie=(TextView) findViewById(R.id.Sxingbie);
        banji=(EditText)findViewById(R.id.Sbanji);
        queding=(Button)findViewById(R.id.studentregister);



        //性别选择
        trBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder tishi=new AlertDialog.Builder(StudentRegisterMseeage.this);

                tishi.setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        xingbie.setText(sexArry[which]);
                        dialog.dismiss();
                    }
                });
                tishi.show();
            }
        });




       // 生日选择
        tr_edit_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //生日控件 与点击事件
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
                        shengri.setText(days);
                    }
                };
                new DatePickerDialog(StudentRegisterMseeage.this, onDateSetListener, mYear, mMonth, mDay).show();
            }
        });
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<StudentMessageDatabase>data= DataSupport.select("xuehao").find(StudentMessageDatabase.class);

                for(StudentMessageDatabase data1:data){//判断学号是否存在
                    if(xuehao.getText().toString().trim().equals(data1.getXuehao())){ xuehaoesists=true; }else{xuehaoesists=false;}
                }
                if (xuehaoesists){
                    Toast.makeText(StudentRegisterMseeage.this, "学号已经存在请重新输入", Toast.LENGTH_SHORT).show();
                }else{//若不存在则录入数据
                    StudentMessageDatabase database=new StudentMessageDatabase();
                    database.setZhuanye(zhuanye.getText().toString().trim());
                    database.setJiguan(jiguan.getText().toString().trim());
                    database.setDianhua(dianhua.getText().toString().trim());
                    database.setBanji(banji.getText().toString().trim());
                    database.setXingbie(xingbie.getText().toString().trim());
                    database.setXingming(xingming.getText().toString().trim());
                    database.setShengri(shengri.getText().toString());
                    database.setXuehao(xuehao.getText().toString().trim());
                    database.save();
                    finish();
                    Toast.makeText(StudentRegisterMseeage.this, "信息录入成功", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //销毁当前活动
        resgint_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
