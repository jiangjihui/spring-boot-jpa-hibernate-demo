package com.utils;

/**
 * 类似restFul，跟前端交互使用json（前后分离）
 */
public class Answer {

    private int status;
    private Object object;

    public Answer(int status, Object object) {
        this.status = status;
        this.object = object;
    }

    public Answer(Object object) {
        this.status = 1;
        this.object = object;
    }

    public static Answer Done(Object object) {
        return new Answer(object);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
