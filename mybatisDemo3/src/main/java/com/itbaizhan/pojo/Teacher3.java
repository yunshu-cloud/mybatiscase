package com.itbaizhan.pojo;

import java.util.List;

public class Teacher3{
    private Integer tid;
    private String tname;
    private List<Classes> classes;

    @Override
    public String toString() {
        return "Teacher2{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", classes=" + classes +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}
