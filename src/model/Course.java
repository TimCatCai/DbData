package model;

import utils.DataUtils;

public class Course {
    private String courseId;
    private String courseName;
    private int credit;
    private int period;
    private static final int COURSE_ID_LENGHT = 10;
    public Course(String courseId, String courseName, int credit, int period) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.period = period;
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(getCourseId(),getCourseName(),getCredit(),getPeriod());
    }

    public String getCourseId() {
        return DataUtils.stringType(courseId);
    }

    public String getCourseName() {
        // 字符型，必需添加单引号
        return  DataUtils.stringType(courseName);
    }

    public String getCredit() {
        return String.valueOf(credit);
    }

    public String getPeriod() {
        return String.valueOf(period);
    }
}
