package iterator;

import iterator.AbstractExcelRowIterator;
import model.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import utils.DataUtils;

public class StudentRowIterator extends AbstractExcelRowIterator<Student> {

    public StudentRowIterator(Sheet sheet) {
        super(sheet);
    }

    @Override
    public Student next() {
        super.index++;
        Row row = sheet.getRow(index);
        int studentId = (int)row.getCell(0).getNumericCellValue();
        String studentName = StringUtils.trim(row.getCell(1).getStringCellValue());
        String sex  = getSex((int)row.getCell(2).getNumericCellValue());

        int departmentId = (int)row.getCell(3).getNumericCellValue();
        String birthDay = DataUtils.dateFormat( 1988 + random.nextInt(16), 1 + random.nextInt(12), 1 + random.nextInt(31));
        return new Student(getStudentId(studentId), studentName, sex, getDepartmentString(departmentId), birthDay);
    }

    private String getSex(int sexInt){
        String sex;
        switch(sexInt){
            case 0:
                sex = "男";
                break;
            case 1:
                sex = "女";
                break;
            default: sex = "未知";
        }
        return sex;
    }
    private String getDepartmentString(int departmentID){
        String departmentString;
        if(departmentID < 10) {
            departmentString = "000000000" + departmentID;
        }else if(departmentID < 100) {
            departmentString = "00000000" + departmentID;
        }else {
            departmentString = "unknown";
        }
        return departmentString;
    }

    private String getStudentId(int studentId){
        String studentIdString;
        if(studentId < 10) {
            studentIdString = "311700000" + studentId;
        }else if(studentId < 100) {
            studentIdString = "31170000" + studentId;
        }else {
            studentIdString = "unknown";
        }
        return studentIdString;
    }

}
