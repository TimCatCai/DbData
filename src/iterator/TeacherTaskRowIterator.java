package iterator;

import model.Course;
import model.TeacherTask;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import utils.DataUtils;

public class TeacherTaskRowIterator extends AbstractExcelRowIterator<TeacherTask> {
    @Override
    public TeacherTask next() {
        super.index++;
        Row row = sheet.getRow(index);
        String teacherId = DataUtils.addLeadingZero((int)row.getCell(0).getNumericCellValue(),"0000000000");
        String courseId = StringUtils.trim(row.getCell(1).getStringCellValue());
        return new TeacherTask(teacherId, courseId);
    }
}
