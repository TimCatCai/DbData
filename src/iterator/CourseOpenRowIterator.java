package iterator;

import model.CourseOpen;
import model.TeacherTask;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import utils.DataUtils;

public class CourseOpenRowIterator extends AbstractExcelRowIterator<CourseOpen> {
    @Override
    public CourseOpen next() {
        super.index++;
        Row row = sheet.getRow(index);
        String teacherId = DataUtils.addLeadingZero((int)row.getCell(0).getNumericCellValue(),"0000000000");
        String courseId = StringUtils.trim(row.getCell(1).getStringCellValue());
        String classroomId = DataUtils.addLeadingZero(RandomUtils.nextInt(1,801), "0000000000");
        return new CourseOpen(teacherId, courseId, classroomId);
    }
}
