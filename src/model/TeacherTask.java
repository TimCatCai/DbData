package model;

import utils.DataUtils;

public class TeacherTask {
    private String teacherId;
    private String courseId;

    public TeacherTask(String teacherId, String courseId) {
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return DataUtils.stringType(teacherId);
    }

    public String getCourseId() {
        return DataUtils.stringType(courseId);
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(getTeacherId(), getCourseId());
    }
}
