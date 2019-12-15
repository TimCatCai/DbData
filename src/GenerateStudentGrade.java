import com.sun.corba.se.spi.orbutil.threadpool.Work;
import model.StudentGrade;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import utils.DataUtils;
import utils.ExcelUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class GenerateStudentGrade {


    public void run(String courseWorkbookPath, String savePath) {
        Path path = Paths.get("E:\\Fdisk\\JavaCode\\SpiderTest\\names");
        Random random = new Random(System.currentTimeMillis());
        List<String> studentGradeDataList = new ArrayList<>();
        String insertHead = DataUtils.insertHead("STUDENT_GRADE(STUDENT_ID,COURSE_ID,GRADE)");
        studentGradeDataList.add(insertHead);
        int sqlServerInsertLimit = 1000;
        int nextLimit = sqlServerInsertLimit;

        int studentTotalNum = 252081;
        int selectedCourseNum;

        // 选课门数的最小值
        int minSelectedCourse = 1;
        // 选课门数的最大值
        int maxSelectedCourse = 10;


        // 当前随机生成的行数
        int selectedCourseIndex = - 1;
        List<String> courseIdsList = getCourseIdsList(courseWorkbookPath);
        int grade;
        int minGrade = 0;
        int maxGrade = 100;
        Set<Integer> courseIndexSet = new HashSet<>(16);
        courseIndexSet.add(selectedCourseIndex);
        int tupleCount = 1;
        int i;
        for ( i = 1; i < studentTotalNum; i++) {
            String studentIdString = DataUtils.addLeadingZero(i, "3117000000");
            // 随机生成学生选课门数，假设为1 ~ 10门
            selectedCourseNum = RandomUtils.nextInt(minSelectedCourse,maxSelectedCourse + 1);
            for (int j = 0; j < selectedCourseNum; j++) {
                while(courseIndexSet.contains(selectedCourseIndex)){
                    selectedCourseIndex = RandomUtils.nextInt(0, courseIdsList.size());
                }
                courseIndexSet.add(selectedCourseIndex);
                grade = RandomUtils.nextInt(minGrade, maxGrade + 1);
                String studentGradeTuple = new StudentGrade(studentIdString, courseIdsList.get(selectedCourseIndex), grade).toString();
                // sql server insert语句每次只能插入1000条元组，所以每1千条数据要作为一次插入
                // 插入的元组数已经到达sql server的上限，修改最后一个元组的逗号为分号，且重新插入一个的insertHead；
                // 即每次只插入1000条元组
                if (tupleCount == nextLimit) {
                    studentGradeDataList.add( studentGradeTuple + ";");
                    studentGradeDataList.add(insertHead);
                    nextLimit += sqlServerInsertLimit;
                } else {
                    studentGradeDataList.add(studentGradeTuple + ",");
                }
                tupleCount ++;
            }
            courseIndexSet.clear();

        }


        // 判断是否最后一条元组数据需要去掉逗号之后加上分号
        // 刚好到达边界，要去掉insert head
        if (i - 1 == nextLimit - sqlServerInsertLimit) {
            studentGradeDataList.remove(studentGradeDataList.size() - 1);
        } else {
            String last = studentGradeDataList.get(studentGradeDataList.size() - 1);
            last = StringUtils.substring(last, 0, last.length() - 1) + ";";
            studentGradeDataList.set(studentGradeDataList.size() - 1, last);
        }

        File insertFile = new File(savePath);
        try {
            FileUtils.writeLines(insertFile, studentGradeDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这里通过随机生成行号来随机选课，在教师任务表中提取出课程号。
     * @param workbookPath  师任务excel表路径
     * @return 获取到的所有课程编号的列表
     */
    private List<String> getCourseIdsList(String workbookPath){
        Workbook workbook = ExcelUtils.getWorkbook(workbookPath);
        // 这里只取第一个工作簿
        Sheet sheet = workbook.getSheetAt(0);
        Row row;
        Set<String> resultSet = new HashSet<>();
        for(int i = 1; i < sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);
            String content = row.getCell(1).getStringCellValue();
            if(!content.trim().isEmpty()){
                resultSet.add(content);
            }
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String [] coursesArray = new String[resultSet.size()];
        resultSet.toArray(coursesArray);
        return Arrays.asList(coursesArray);
    }
}
