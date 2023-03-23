package com.yunze.LibraryManagementSystem.modules.evaluate.entity;

public class Label {
    private int id;
    private String name;
    private int view;
    private int cite;

    public Label() {
    }

    public Label(int id, String name, int view, int cite) {
        this.id = id;
        this.name = name;
        this.view = view;
        this.cite = cite;
    }

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

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getCite() {
        return cite;
    }

    public void setCite(int cite) {
        this.cite = cite;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", view=" + view +
                ", cite=" + cite +
                '}';
    }
}
