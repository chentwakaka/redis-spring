package com.chent.redis.service;

import com.chent.redis.model.SubjectInfo;

/**
 * Created by chentong on 2016/9/6.
 */
public interface SubjectInfoService {

    boolean save(SubjectInfo subjectInfo);

    SubjectInfo get(int subjectId);
}
