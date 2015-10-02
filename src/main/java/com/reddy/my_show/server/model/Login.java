package com.reddy.my_show.server.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by varshini on 28/9/15.
 */
@XmlRootElement
public class Login {

    private String userName;
    private String password;

    public Login(){}

    public Login(String userName,String password){
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
