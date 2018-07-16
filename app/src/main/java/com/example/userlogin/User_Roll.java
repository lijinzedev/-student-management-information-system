package com.example.userlogin;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class User_Roll extends DataSupport {
    private int id;
private List<LoginData> loginData=new ArrayList<LoginData>();
private List<RollDatabase> rollDatabases=new ArrayList<RollDatabase>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LoginData> getLoginData() {
        return loginData;
    }

    public List<RollDatabase> getRollDatabases() {
        return rollDatabases;
    }

    public void setRollDatabases(List<RollDatabase> rollDatabases) {
        this.rollDatabases = rollDatabases;
    }

    public void setLoginData(List<LoginData> loginData) {
        this.loginData = loginData;
    }


}
