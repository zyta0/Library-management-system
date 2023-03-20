package com.yunze.LibraryManagementSystem.modules.login.entity;

public class Reader extends User {
    private int readerId;
    private String password;
    private String name;
    private String telephone;
    private String email;
    private String dept;
    private Integer status;
    private int readerType;
    private String demo;

    public Reader() {
    }

    public Reader(int readerId, String name, String password, String telephone, String email, String dept, Integer status, int readerType, String demo) {
        this.readerId = readerId;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.dept = dept;
        this.status = status;
        this.readerType = readerType;
        this.demo = demo;
    }

    public Reader(String name, String password, String telephone, String email, String dept, Integer status, int readerType, String demo) {
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.dept = dept;
        this.status = status;
        this.readerType = readerType;
        this.demo = demo;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getReaderType() {
        return readerType;
    }

    public void setReaderType(int readerType) {
        this.readerType = readerType;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", status=" + status +
                ", readerType=" + readerType +
                ", demo='" + demo + '\'' +
                '}';
    }
}
