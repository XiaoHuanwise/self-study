package com.twt.selfstudy.entity;

import java.io.Serializable;

/**
 * edu_b_teachbuilding
 * @author 
 */
public class EduBTeachbuilding implements Serializable {
    private String buildingId;

    private String building;

    private String campusId;

    private String areaId;

    private static final long serialVersionUID = 1L;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
        EduBTeachbuilding other = (EduBTeachbuilding) that;
        return (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getBuilding() == null ? other.getBuilding() == null : this.getBuilding().equals(other.getBuilding()))
            && (this.getCampusId() == null ? other.getCampusId() == null : this.getCampusId().equals(other.getCampusId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getBuilding() == null) ? 0 : getBuilding().hashCode());
        result = prime * result + ((getCampusId() == null) ? 0 : getCampusId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", buildingId=").append(buildingId);
        sb.append(", building=").append(building);
        sb.append(", campusId=").append(campusId);
        sb.append(", areaId=").append(areaId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}