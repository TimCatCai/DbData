package model;

import utils.DataUtils;

public class CourseOpen {
    private String courseId;
    private String teacherId;
    private String classroomId;

    public CourseOpen(String courseId, String teacherId, String classroomId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.classroomId = classroomId;
    }
    public String getTeacherId() {
        return DataUtils.stringType(teacherId);
    }

    public String getCourseId() {
        return DataUtils.stringType(courseId);
    }

    public String getClassroomId() {
        return DataUtils.stringType(classroomId);
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(getTeacherId(), getCourseId(),getClassroomId());
    }

}
