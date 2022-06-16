package com.twt.selfstudy.service.impl;

import com.twt.selfstudy.dao.ClassroomStatusDao;
import com.twt.selfstudy.entity.ClassroomDayData;
import com.twt.selfstudy.entity.ClassroomStatus;
import com.twt.selfstudy.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    ClassroomStatusDao classroomStatus;

    @Override
    public List<ClassroomStatus> getClassroomStatus(String term, String week, String day) {

        List<ClassroomStatus> dbClassroomStatus = classroomStatus.selectClassroomStatus(term,week,day);

        return dbClassroomStatus;
    }

    @Override
    public List<ClassroomDayData> getClassroomDayData(String term, String week, String classroomId) {

        List<ClassroomDayData> dbClassroomStatus = classroomStatus.selectClassroomDayData(term,week,classroomId);

        return dbClassroomStatus;
    }
}
