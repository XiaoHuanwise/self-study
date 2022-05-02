package com.twt.selfstudy.dao;

import com.twt.selfstudy.pojo.entity.ClassroomDayData;
import com.twt.selfstudy.pojo.entity.ClassroomStatus;
import com.twt.selfstudy.pojo.entity.ClassroomStatusKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassroomStatusDao {
    int deleteByPrimaryKey(ClassroomStatusKey key);

    int insert(ClassroomStatus record);

    int insertSelective(ClassroomStatus record);

    ClassroomStatus selectByPrimaryKey(ClassroomStatusKey key);

    int updateByPrimaryKeySelective(ClassroomStatus record);

    int updateByPrimaryKey(ClassroomStatus record);

    List<ClassroomStatus> selectClassroomStatus(String term,String week, String day);

    List<ClassroomDayData> selectClassroomDayData(String term, String week, String classroomId);
}