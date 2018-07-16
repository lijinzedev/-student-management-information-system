package com.example.userlogin;

import org.litepal.crud.DataSupport;

public class StudentMessageDatabase extends DataSupport {
    private String xuehao;  //学号
    private String xingming;//姓名
    private String banji; //班级
    private String xingbie;  //性别
    private String dianhua; //电话
    private String jiguan; //籍贯
    private String zhuanye;//专业
    private String shengri; //生日
private int id;  //主码id 自增长
private User_Roll user_roll;

    public User_Roll getUser_roll() {
        return user_roll;
    }

    public void setUser_roll(User_Roll user_roll) {
        this.user_roll = user_roll;
    }

    public String getDianhua() {
        return dianhua;
    }

    public String getJiguan() {
        return jiguan;
    }

    public String getShengri() {
        return shengri;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }

    public void setShengri(String shengri) {
        this.shengri = shengri;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXuehao() {
        return xuehao;
    }

    public String getXingming() {
        return xingming;
    }

    public String getXingbie() {
        return xingbie;
    }

    public String getBanji() {
        return banji;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

}
