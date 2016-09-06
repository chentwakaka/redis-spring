package com.chent.redis.dao;

import com.chent.redis.model.SubjectInfo;

/**
 * Created by chentong on 2016/9/6.
 */
public interface SubjectInfoDao {

    boolean save(SubjectInfo subjectInfo);

    SubjectInfo get(String subjectId);
}
