package com.chent.redis.service;

import com.chent.redis.dao.SubjectInfoDao;
import com.chent.redis.model.SubjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chentong on 2016/9/6.
 */
@Service
public class SubjectInfoServiceImpl implements SubjectInfoService {

    @Autowired
    private SubjectInfoDao subjectInfoDao;

    @Override
    public boolean save(SubjectInfo subjectInfo) {
        return subjectInfoDao.save(subjectInfo);
    }

    @Override
    public SubjectInfo get(int subjectId) {
        return subjectInfoDao.get(String.valueOf(subjectId));
    }
}
