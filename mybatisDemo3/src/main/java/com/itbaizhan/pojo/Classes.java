package com.itbaizhan.pojo;


import java.util.List;

public class Classes {
    private int cid;
    private String className;
    private List<Student> studentList;
    private List<Teacher3> teacherList;

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", className='" + className + '\'' +
                ", studentList=" + studentList +
                ", teacherList=" + teacherList +
                '}';
    }

    public List<Teacher3> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher3> teacherList) {
        this.teacherList = teacherList;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
