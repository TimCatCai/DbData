package model;

import org.apache.commons.lang3.StringUtils;
import utils.DataUtils;

public class StudentGrade {
    private String studentId;
    private String courseId;
    private int grade;

    public StudentGrade(String studentId, String courseId, int grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public String getStudentId() {
        return DataUtils.stringType(studentId);
    }

    public String getCourseId() {
        return DataUtils.stringType(courseId);
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(getStudentId(), getCourseId(), String.valueOf(getGrade()));
    }
}
