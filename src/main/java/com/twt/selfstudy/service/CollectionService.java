package com.twt.selfstudy.service;

import com.twt.selfstudy.entity.CollectionKey;

import java.util.List;

public interface CollectionService {
    int insertCollection(String user_id,String classroom_id);
    List<CollectionKey> selectCollections(String user_id);
    int deleteCollection(CollectionKey collectionKey);

}
