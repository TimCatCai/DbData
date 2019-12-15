package iterator;

import iterator.AbstractExcelRowIterator;
import model.Teacher;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import utils.DataUtils;

public class TeacherRowIterator extends AbstractExcelRowIterator<Teacher> {

    public TeacherRowIterator(Sheet sheet) {
        super(sheet);
    }

    public TeacherRowIterator(){

    }
    @Override
    public Teacher next() {
        super.index++;
        // 随机生成学分与学时
        Row row = sheet.getRow(index);
        String teacherId = DataUtils.addLeadingZero((int)row.getCell(0).getNumericCellValue(), "0000000000");
        String name = row.getCell(1).getStringCellValue();
        String sex = DataUtils.generateSexString();
        String departmentId = DataUtils.addLeadingZero(RandomUtils.nextInt(0,16), "0000000000");
        String birthDay = DataUtils.generateRandomDate(1965,1985);
        String joinWorkDate = DataUtils.generateRandomDate(2005,2019);;
        return new Teacher(teacherId, name, sex, departmentId,birthDay, joinWorkDate);
    }
}
