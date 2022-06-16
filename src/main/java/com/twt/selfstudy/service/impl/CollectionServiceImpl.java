package com.twt.selfstudy.service.impl;

import com.twt.selfstudy.dao.CollectionDao;
import com.twt.selfstudy.entity.CollectionKey;
import com.twt.selfstudy.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Resource
    CollectionDao collectionDao;

    @Override
    public int insertCollection(String user_id, String classroom_id) {

        List<CollectionKey> collectionKey1 = collectionDao.selectCollection(user_id,classroom_id);

        if (!collectionKey1.isEmpty())
            return 2;

        return collectionDao.insertCollection(user_id,classroom_id);

    }

    @Override
    public List<CollectionKey> selectCollections(String user_id) {

        List<CollectionKey> dbCollections = collectionDao.selectCollections(user_id);

        return dbCollections;

    }

    @Override
    public int deleteCollection(CollectionKey collectionKey) {

        List<CollectionKey> collectionKey1 = collectionDao.selectCollection(collectionKey.getUserId(),collectionKey.getClassroomId());

        if (collectionKey1.isEmpty())
            return 0;

        return collectionDao.deleteByPrimaryKey(collectionKey);
    }

}
