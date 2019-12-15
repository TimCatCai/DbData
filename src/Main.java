import iterator.CourseOpenRowIterator;
import iterator.TeacherTaskRowIterator;
import iterator.TextbookRowIterator;
import iterator.TextbookSelectRowIterator;
import model.CourseOpen;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String studentDataPath = "files/excel_data_source/student.xlsx";
        String studentInsertFileSavePath = "files/insert_files/student_insert_file.sql";
        String studentTable = "STUDENT(STUDENT_ID,STUDENT_NAME,SEX,DEPARTMENT_ID,BIRTHDAY)";
//`       // 插入教师表
//        String teacherDataPath = "files/excel_data_source/teacher.xlsx";
//        String teacherInsertFileSavePath = "files/insert_files/teacher_insert_file.sql";
//        String teacherTable = "TEACHER(TEACHER_ID,TEACHER_NAME,SEX,DEPARTMENT_ID,BIRTHDAY,JOINDAY)";
//        iterator.TeacherRowIterator it = new iterator.TeacherRowIterator();
//        GenerateInsertFile.<model.Teacher, iterator.TeacherRowIterator>generateInsertFile(it,
//                teacherTable, teacherDataPath, teacherInsertFileSavePath);

//        // 插入课室表
//        String classroomDataPath = "files/excel_data_source/classroom.xlsx";
//        String classroomInsertFileSavePath = "files/insert_files/classroom_insert_file.sql";
//        String classroomTable = "CLASSROOM(CLASSROOM_ID, LACTION,CAPACITY)";
//        iterator.ClassroomIterator it = new iterator.ClassroomIterator();
//        GenerateInsertFile.generateInsertFile(it,
//               classroomTable, classroomDataPath, classroomInsertFileSavePath);

//        String courseDataPath = "files/excel_data_source/course.xlsx";
//        String courseInsertFileSavePath = "files/insert_files/course_insert_file.sql";
//        String courseTable = "COURSE(COURSE_ID,COURSE_NAME,CREDIT,PERIOD)";
//        iterator.CourseRowIterator it = new iterator.CourseRowIterator();
//        GenerateInsertFile.generateInsertFile(it,
//               courseTable, courseDataPath, courseInsertFileSavePath);

//        String textbookDataPath = "files/excel_data_source/textbook.xlsx";
//        String textbookInsertFileSavePath = "files/insert_files/textbook_insert_file.sql";
//        String textbookTable = "TEXTBOOK(TEXTBOOK_ID, TEXTBOOK_NAME, PRESS, PRICE, PUBLISH_DAY)";
//        TextbookRowIterator it = new TextbookRowIterator();
//        GenerateInsertFile.generateInsertFile(it,
//               textbookTable, textbookDataPath, textbookInsertFileSavePath);

//        String textbookSelectDataPath = "files/excel_data_source/textbook_select.xlsx";
//        String textbookSelectInsertFileSavePath = "files/insert_files/textbook_select_insert_file.sql";
//        String textbookSelectTable = "TEXTBOOK_SELECT(COURSE_ID, TEXTBOOK_ID, AMOUNT)";
//        TextbookSelectRowIterator it = new TextbookSelectRowIterator();
//        GenerateInsertFile.generateInsertFile(it,
//                textbookSelectTable, textbookSelectDataPath, textbookSelectInsertFileSavePath);

//        String teacherCourseTaskDataPath = "files/excel_data_source/teacher_course_task.xlsx";
//        String teacherCourseTaskInsertFileSavePath = "files/insert_files/teacher_course_task_insert_file.sql";
//        String teacherCourseTaskTable = "TEACHER_COURSE_TASK(TEACHER_ID, COURSE_ID)";
//        TeacherTaskRowIterator it = new TeacherTaskRowIterator();
//        GenerateInsertFile.generateInsertFile(it,
//                teacherCourseTaskTable, teacherCourseTaskDataPath, teacherCourseTaskInsertFileSavePath);
//        String courseOpenDataPath = "files/excel_data_source/teacher_course_task.xlsx";
//        String courseOpenInsertFileSavePath = "files/insert_files/course_open_insert_file.sql";
//        String courseOpenTable = "COURSE_OPEN(COURSE_ID,TEACHER_ID,CLASSROOM_ID)";
//        CourseOpenRowIterator it = new CourseOpenRowIterator();
//        GenerateInsertFile.generateInsertFile(it,
//                courseOpenTable, courseOpenDataPath, courseOpenInsertFileSavePath);

        String courseOpenWorkbookPath = "files/excel_data_source/teacher_course_task.xlsx";
        String studentGradeInsertFileSavePath = "files/insert_files/student_grade_insert_file.sql";
        GenerateStudentGrade generateStudentGrade = new GenerateStudentGrade();
        generateStudentGrade.run(courseOpenWorkbookPath, studentGradeInsertFileSavePath);
    }


}
