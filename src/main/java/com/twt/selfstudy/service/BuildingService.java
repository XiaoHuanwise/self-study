package com.twt.selfstudy.service;

import com.twt.selfstudy.pojo.entity.EduBCourseClassroom;
import com.twt.selfstudy.pojo.entity.EduBTeachbuilding;

import java.util.List;

public interface BuildingService {

    List<EduBTeachbuilding> getAllBuildings ();
    List<EduBCourseClassroom> getAllCourses();

}
