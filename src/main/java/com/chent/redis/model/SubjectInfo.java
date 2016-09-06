package com.chent.redis.model;

import java.io.Serializable;

/**
 * Created by chentong on 2016/9/6.
 */
public class SubjectInfo implements Serializable{

    private int subjectId;

    private String subjectName;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public SubjectInfo(int subjectId,String subjectName){
        super();
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
}
