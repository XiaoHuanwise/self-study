package com.twt.selfstudy.entity;

public class ClassroomStatusforScheduled {
    private String term;
    private String classroomId;
    private String week;
    private String day;
    private String status;

    public ClassroomStatusforScheduled(String term, String classroomId, String week, String day, String status) {
        this.term = term;
        this.classroomId = classroomId;
        this.week = week;
        this.day = day;
        this.status = status;
    }

    public ClassroomStatusforScheduled(String term, String classroomId, Integer week, Integer day, String status) {
        this.term = term;
        this.classroomId = classroomId;
        this.week = week.toString();
        this.day = day.toString();
        this.status = status;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
