package com.twt.selfstudy.pojo.entity;

import java.io.Serializable;

/**
 * classroom_status
 * @author 
 */
public class ClassroomStatusKey implements Serializable {
    private String classroomId;

    private String week;

    private String day;

    private String term;

    private static final long serialVersionUID = 1L;

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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}