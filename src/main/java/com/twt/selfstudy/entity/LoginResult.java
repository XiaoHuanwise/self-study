package com.twt.selfstudy.entity;

public class LoginResult {
    private String userNumber;
    private String nickname;
    private String telephone;
    private String email;
    private String token;
    private String role;
    private String realname;
    private String gender;
    private String department;
    private String major;
    private String stuType;
    private String avatar;
    private String campus;
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
    public String getUserNumber() {
        return userNumber;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getRealname() {
        return realname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public String getMajor() {
        return major;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }
    public String getStuType() {
        return stuType;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
    public String getCampus() {
        return campus;
    }
}
