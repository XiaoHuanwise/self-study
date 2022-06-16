package com.twt.selfstudy.dao;

import com.twt.selfstudy.entity.CollectionKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionDao {
    int deleteByPrimaryKey(CollectionKey key);

    int insert(CollectionKey record);

    int insertSelective(CollectionKey record);

    int insertCollection(String user_id, String classroom_id);

    List<CollectionKey> selectCollections(String userId);

    List<CollectionKey> selectCollection(String user_id,String classroom_id);
}