package com.example.userlogin;

import org.litepal.crud.DataSupport;

public class RoleTable extends DataSupport {
    private String superuser;
    private String commonuser;

    public String getCommonuser() {
        return commonuser;
    }

    public String getSuperuser() {
        return superuser;
    }

    public void setCommonuser(String commonuser) {
        this.commonuser = commonuser;
    }

    public void setSuperuser(String superuser) {
        this.superuser = superuser;
    }
}
