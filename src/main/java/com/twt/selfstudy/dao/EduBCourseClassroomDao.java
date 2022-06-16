package com.twt.selfstudy.dao;

import com.twt.selfstudy.entity.EduBCourseClassroom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduBCourseClassroomDao {
    int insert(EduBCourseClassroom record);

    int insertSelective(EduBCourseClassroom record);

    List<EduBCourseClassroom> selectAllCourses();
}