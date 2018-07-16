package com.example.userlogin;

import org.litepal.crud.DataSupport;

public class LoginData extends DataSupport {
    private int id;
    private String user;
    private String pwd;
    private String parentname;
    private String lovename;
    private String xingyunshuzi;
    private String youxiang;
    private String jiatingzhuzhi;
    private String chushengnianyue;
    private String dianhuahaoma;
    private String yonghumingcheng;
    private User_Roll user_roll;

    public void setUser_roll(User_Roll user_roll) {
        this.user_roll = user_roll;
    }

    public User_Roll getUser_roll() {
        return user_roll;
    }

    public String getYonghumingcheng() {
        return yonghumingcheng;
    }

    public void setYonghumingcheng(String yonghumingcheng) {
        this.yonghumingcheng = yonghumingcheng;
    }

    public String getDianhuahaoma() {
        return dianhuahaoma;
    }

    public void setDianhuahaoma(String dianhuahaoma) {
        this.dianhuahaoma = dianhuahaoma;
    }

    public String getChushengnianyue() {
        return chushengnianyue;
    }

    public void setChushengnianyue(String chushengnianyue) {
        this.chushengnianyue = chushengnianyue;
    }

    public String getJiatingzhuzhi() {
        return jiatingzhuzhi;
    }

    public void setJiatingzhuzhi(String jiatingzhuzhi) {
        this.jiatingzhuzhi = jiatingzhuzhi;
    }

    public String getYouxiang() {
        return youxiang;
    }

    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang;
    }

    public String getXingyunshuzi() {
        return xingyunshuzi;
    }


    public void setXingyunshuzi(String xingyunshuzi) {
        this.xingyunshuzi = xingyunshuzi;
    }

    public String getLovename() {
        return lovename;
    }

    public String getParentname() {
        return parentname;
    }


    public void setLovename(String lovename) {
        this.lovename = lovename;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public int getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
