package com.twt.selfstudy.service.impl;

import com.twt.selfstudy.dao.EduBCourseClassroomDao;
import com.twt.selfstudy.dao.EduBTeachbuildingDao;
import com.twt.selfstudy.entity.EduBCourseClassroom;
import com.twt.selfstudy.entity.EduBTeachbuilding;
import com.twt.selfstudy.service.BuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Resource
    EduBTeachbuildingDao buildings;

    @Resource
    EduBCourseClassroomDao courses;

    @Override
    public List<EduBTeachbuilding> getAllBuildings() {
        List<EduBTeachbuilding> dbBuildings =  buildings.selectAllBuildings();
        return dbBuildings;
    }

    @Override
    public List<EduBCourseClassroom> getAllCourses() {
        List<EduBCourseClassroom> dbCourses = courses.selectAllCourses();
        return dbCourses;
    }
}
