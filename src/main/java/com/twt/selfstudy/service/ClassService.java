package com.twt.selfstudy.service;

import com.twt.selfstudy.pojo.entity.ClassroomDayData;
import com.twt.selfstudy.pojo.entity.ClassroomStatus;

import java.util.List;

public interface ClassService {

    List<ClassroomStatus> getClassroomStatus(String term,String week,String day);
    List<ClassroomDayData> getClassroomDayData(String term,String week,String classroomId);
}
