package iterator;

import iterator.AbstractExcelRowIterator;
import model.Course;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class CourseRowIterator extends AbstractExcelRowIterator<Course> {

    public CourseRowIterator(Sheet sheet) {
        super(sheet);
    }
    public CourseRowIterator(){

    }
    @Override
    public Course next() {
        super.index++;
        // 随机生成学分与学时
        Row row = sheet.getRow(index);
        String courseId = row.getCell(0).getStringCellValue();
        String courseName = StringUtils.trim(row.getCell(1).getStringCellValue());
        int credit = random.nextInt(10) + 1;
        int period = random.nextInt(100) + 1;
        return new Course(courseId, courseName, credit, period);
    }
}
