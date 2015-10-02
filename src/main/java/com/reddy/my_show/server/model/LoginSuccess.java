package com.reddy.my_show.server.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by varshini on 28/9/15.
 */
@XmlRootElement
public class LoginSuccess {
    private String status;
    private String role;
    private String loginId;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
