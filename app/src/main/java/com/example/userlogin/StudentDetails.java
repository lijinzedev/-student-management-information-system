package com.example.userlogin;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class StudentDetails extends BaseActivity {
private EditText xingming;
private EditText banji;
private EditText xuehao;
private TextView xingbie;
private EditText zhuanye;
private EditText dianhua;
private EditText jiguan;
private TextView shengri;
private Button queding;
private String name;
private  String sex;
private String sno;
private String classname;
private int idstudent;
private String intid;
private  Button cancle;
private TableRow tr_edit_birth;        //生日选择
private  TableRow trBirth;           //性别选择
private String z;                      //获取账号
private String d;                      //获取密码
private String j;                       //获取籍贯
    private String birthdy;               //获取生日
    private String[] sexArry = new String[]{ "女", "男"};// 性别选择
    private String caozuoquanxian;;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);
        caozuoquanxian=MainActivity.caozuoquanxian;
        Intent message=getIntent();//获取点击的item信息数据
        Bundle studentmessage=message.getExtras();
        name=studentmessage.getString("姓名");
        sex=studentmessage.getString("性别");
        sno=studentmessage.getString("学号");
        classname=studentmessage.getString("班级");

     List<StudentMessageDatabase> studentid= DataSupport.where("xuehao=?",sno).find(StudentMessageDatabase.class);
       for (StudentMessageDatabase database:studentid){
            idstudent=database.getId();
            intid=""+idstudent;
           Log.d("id", "onCreate: "+idstudent);
       }
List<StudentMessageDatabase>studentMessageDatabaseList=DataSupport.where("xuehao=? and xingming=?",sno,name).find(StudentMessageDatabase.class);
       for (StudentMessageDatabase a:studentMessageDatabaseList){
           z=a.getZhuanye();
           d=a.getDianhua();
           j=a.getJiguan();
           birthdy=a.getShengri();
       }
        trBirth = (TableRow) findViewById(R.id.tr_edit_gender);
       zhuanye=(EditText)findViewById(R.id.updatazhuanye);
        dianhua=(EditText)findViewById(R.id.updatadianhua);
        jiguan=(EditText)findViewById(R.id.updatajiguan);
        xingming=(EditText)findViewById(R.id.updataxingming);
        xingbie=(TextView)findViewById(R.id.updataxingbie);
        xuehao=(EditText)findViewById(R.id.updataxuehao);
        banji=(EditText)findViewById(R.id.updatabanji);
        queding=(Button)findViewById(R.id.updataqueding);
        cancle=(Button)findViewById(R.id.btn_edit_back) ;
        shengri=(TextView)findViewById(R.id.updatatvshengri) ;
        tr_edit_birth=(TableRow)findViewById(R.id.updatatrshengri);
        xingming.setText(name);
        xingbie.setText(sex);
        xuehao.setText(sno);
        banji.setText(classname);
        zhuanye.setText(z);
        dianhua.setText(d);
        jiguan.setText(j);
        shengri.setText(birthdy);
        trBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder tishi=new AlertDialog.Builder(StudentDetails.this);

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
        tr_edit_birth.setOnClickListener(new View.OnClickListener() {
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
                       shengri.setText(days);
                    }
                };
                new DatePickerDialog(StudentDetails.this, onDateSetListener, mYear, mMonth, mDay).show();
            }
        });
        if ("普通用户".equals(caozuoquanxian)){
            queding.setVisibility(View.INVISIBLE);
        }
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentMessageDatabase database=new StudentMessageDatabase();
                database.setXingming(xingming.getText().toString().trim());
                database.setXuehao(xuehao.getText().toString().trim());
                database.setShengri(shengri.getText().toString());
                database.setXingbie(xingbie.getText().toString().trim());
                database.setBanji(banji.getText().toString().trim());
                database.setZhuanye(zhuanye.getText().toString().trim());
                database.setJiguan(jiguan.getText().toString().trim());
                database.setDianhua(dianhua.getText().toString().trim());
                database.updateAll("id = ?",intid);
                Toast.makeText(StudentDetails.this, "信息修改成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
cancle.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
    }




    //自定义活动开启方式用于传数据
    public static void actionstart(Context context,String xuehao,String banji,String xingming,String xingbie){
        Intent intent=new Intent(context,StudentDetails.class);
        Bundle bundle=new Bundle();
        bundle.putCharSequence("学号",xuehao);
        bundle.putCharSequence("班级",banji);
        bundle.putCharSequence("姓名",xingming);
        bundle.putCharSequence("性别",xingbie);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
