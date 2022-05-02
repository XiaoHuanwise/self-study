package com.twt.selfstudy.pojo.entity;

import java.io.Serializable;

/**
 * edu_b_course_classroom
 * @author 
 */
public class EduBCourseClassroom implements Serializable {
    private String term;

    private String classroomId;

    private Integer capacity;

    private String buildingId;

    private String classroomTypeId;

    private String classroom;

    private static final long serialVersionUID = 1L;

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getClassroomTypeId() {
        return classroomTypeId;
    }

    public void setClassroomTypeId(String classroomTypeId) {
        this.classroomTypeId = classroomTypeId;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EduBCourseClassroom other = (EduBCourseClassroom) that;
        return (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
            && (this.getClassroomId() == null ? other.getClassroomId() == null : this.getClassroomId().equals(other.getClassroomId()))
            && (this.getCapacity() == null ? other.getCapacity() == null : this.getCapacity().equals(other.getCapacity()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getClassroomTypeId() == null ? other.getClassroomTypeId() == null : this.getClassroomTypeId().equals(other.getClassroomTypeId()))
            && (this.getClassroom() == null ? other.getClassroom() == null : this.getClassroom().equals(other.getClassroom()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getClassroomId() == null) ? 0 : getClassroomId().hashCode());
        result = prime * result + ((getCapacity() == null) ? 0 : getCapacity().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getClassroomTypeId() == null) ? 0 : getClassroomTypeId().hashCode());
        result = prime * result + ((getClassroom() == null) ? 0 : getClassroom().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", term=").append(term);
        sb.append(", classroomId=").append(classroomId);
        sb.append(", capacity=").append(capacity);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", classroomTypeId=").append(classroomTypeId);
        sb.append(", classroom=").append(classroom);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}