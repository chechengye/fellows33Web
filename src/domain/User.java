package domain;

import java.io.Serializable;

public class User implements Serializable{

    private int id;
    private String uname;
    private String upassword;
    private String email;
    private String hobby;
    private String sex;
    private String code;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", email='" + email + '\'' +
                ", hobby='" + hobby + '\'' +
                ", sex='" + sex + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
