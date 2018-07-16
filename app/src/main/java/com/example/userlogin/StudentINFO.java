package com.example.userlogin;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

public class StudentINFO extends AppCompatActivity {
    private TextView zongshu;
    private TextView girl;
    private TextView boy;
    private Button back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_info);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //将状态栏颜色设置为与toolbar一致
            getWindow().setStatusBarColor(getResources().getColor(R.color.normal_blue));
        }


        zongshu=(TextView)findViewById(R.id.xueshengzongshu);
        girl=(TextView)findViewById(R.id.nvsheng);
        boy=(TextView)findViewById(R.id.nansheng);
        back=(Button)findViewById(R.id.xueshengback);
        List<StudentMessageDatabase>sunm= DataSupport.findAll(StudentMessageDatabase.class);
        List<StudentMessageDatabase>girlsunm= DataSupport.where("xingbie=?","女").find(StudentMessageDatabase.class);
        List<StudentMessageDatabase>boysunm= DataSupport.where("xingbie=?","男").find(StudentMessageDatabase.class);
        String a=""+sunm.size();
        String b=""+girlsunm.size();
        String c=""+boysunm.size();
        zongshu.setText(a);
girl.setText(b);
boy.setText(c);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});

    }
}
