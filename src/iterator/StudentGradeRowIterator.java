package iterator;

import iterator.AbstractExcelRowIterator;
import model.CourseOpen;
import model.StudentGrade;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import utils.DataUtils;

public class StudentGradeRowIterator extends AbstractExcelRowIterator<StudentGrade> {
    @Override
    public StudentGrade next() {
        super.index++;
        Row row = sheet.getRow(RandomUtils.nextInt(0,760));

        String courseId = StringUtils.trim(row.getCell(1).getStringCellValue());
        String classroomId = DataUtils.addLeadingZero(RandomUtils.nextInt(1,801), "0000000000");
        return null;
    }
}
