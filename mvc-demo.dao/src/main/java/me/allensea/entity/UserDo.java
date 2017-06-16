package me.allensea.entity;

import java.io.Serializable;

public class UserDo implements Serializable {

    private static final long serialVersionUID = -8907406333808506395L;
    private int               id;
    private String            name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
