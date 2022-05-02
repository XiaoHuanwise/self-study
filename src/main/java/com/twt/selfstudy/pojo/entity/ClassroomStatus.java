package com.twt.selfstudy.pojo.entity;

import java.io.Serializable;

/**
 * classroom_status
 * @author 
 */
public class ClassroomStatus extends ClassroomStatusKey implements Serializable {
    private String status;

    private String classroom;

    private int capacity;

    private String building;

    private String buildingId;

    private String campusId;

    private static final long serialVersionUID = 1L;

    public ClassroomStatus() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }
}