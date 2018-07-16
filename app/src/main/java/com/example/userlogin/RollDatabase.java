package com.example.userlogin;

import org.litepal.crud.DataSupport;

public class RollDatabase extends DataSupport {
    private String Roll_User;
    private String Roll_Administrator;
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoll_Administrator(String roll_Administrator) {
        Roll_Administrator = roll_Administrator;
    }

    public void setRoll_User(String roll_User) {
        Roll_User = roll_User;
    }

    public String getRoll_Administrator() {
        return Roll_Administrator;
    }

    public String getRoll_User() {
        return Roll_User;
    }
}
