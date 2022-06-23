package com.twt.selfstudy.entity;

public class FixedOccupy {
    private String term;
    private String day;
    private String week;
    private int beginCourse;
    private int endCourse;
    private String classroomId;

    public FixedOccupy(String term, String day, String week, int beginCourse, int endCourse, String classroomId) {
        this.term = term;
        this.day = day;
        this.week = week;
        this.beginCourse = beginCourse;
        this.endCourse = endCourse;
        this.classroomId = classroomId;
    }

    public FixedOccupy(String term, Integer day, String week, int beginCourse, int endCourse, String classroomId) {
        this.term = term;
        this.day = day.toString();
        this.week = week;
        this.beginCourse = beginCourse;
        this.endCourse = endCourse;
        this.classroomId = classroomId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getBeginCourse() {
        return beginCourse;
    }

    public void setBeginCourse(int beginCourse) {
        this.beginCourse = beginCourse;
    }

    public int getEndCourse() {
        return endCourse;
    }

    public void setEndCourse(int endCourse) {
        this.endCourse = endCourse;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }
}
