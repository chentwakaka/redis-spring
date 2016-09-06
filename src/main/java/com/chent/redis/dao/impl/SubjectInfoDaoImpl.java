package com.chent.redis.dao.impl;

import com.chent.redis.dao.AbstractBaseRedisDao;
import com.chent.redis.dao.SubjectInfoDao;
import com.chent.redis.model.SubjectInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * Created by chentong on 2016/9/6.
 */
@Component
public class SubjectInfoDaoImpl extends AbstractBaseRedisDao implements SubjectInfoDao {

    @Override
    public boolean save(final SubjectInfo subjectInfo) {
        boolean result = (Boolean)redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(String.valueOf(subjectInfo.getSubjectId()));
                byte[] value = serializer.serialize(subjectInfo.getSubjectName());
                return redisConnection.setNX(key, value);
            }
        });

        return result;
    }

    @Override
    public SubjectInfo get(final String subjectId) {
        SubjectInfo result = (SubjectInfo)redisTemplate.execute(new RedisCallback<SubjectInfo>() {
            @Override
            public SubjectInfo doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(subjectId);
                byte[] value = redisConnection.get(key);
                if (value == null) {
                    return null;
                }
                String subjectName = serializer.deserialize(value);
                return new SubjectInfo(Integer.parseInt(subjectId), subjectName);
            }
        });
        return result;
    }
}
