package com.yunze.LibraryManagementSystem.modules.evaluate.entity;

public class Reader extends User {
    private int readerId;
    private String name;
    private String telephone;
    private String email;
    private String dept;
    private Integer status;
    private int readerType;
    private String demo;

    public Reader() {
    }

    public Reader(String name, String telephone, String email, String dept, Integer status, int readerType, String demo) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.dept = dept;
        this.status = status;
        this.readerType = readerType;
        this.demo = demo;
    }

    public Reader(int readerId, String name, String telephone, String email, String dept, Integer status, int readerType, String demo) {
        this.readerId = readerId;
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

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", status=" + status +
                ", readerType=" + readerType +
                ", demo='" + demo + '\'' +
                '}';
    }
}
