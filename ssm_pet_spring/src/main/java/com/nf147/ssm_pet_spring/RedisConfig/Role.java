package com.nf147.ssm_pet_spring.RedisConfig;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = 6977402643848374753L;

    private long id ;
    private String roleName;
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
