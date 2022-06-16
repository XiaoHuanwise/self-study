package com.twt.selfstudy.dao;

import com.twt.selfstudy.entity.EduBTeachbuilding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduBTeachbuildingDao {
    int deleteByPrimaryKey(String buildingId);

    int insert(EduBTeachbuilding record);

    int insertSelective(EduBTeachbuilding record);

    EduBTeachbuilding selectByPrimaryKey(String buildingId);

    int updateByPrimaryKeySelective(EduBTeachbuilding record);

    int updateByPrimaryKey(EduBTeachbuilding record);

    List<EduBTeachbuilding> selectAllBuildings();
}