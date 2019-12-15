package utils;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    public static final String STRING_TYPE = "string";
    public static final String DOUBLE_TYPE = "double";
    public static Workbook getWorkbook(String filePath){
        if(filePath == null){
            return null;
        }
        FileInputStream is = null;
        Workbook workbook  =  null;
        try {
            is = new FileInputStream(filePath);
            if(filePath.toLowerCase().endsWith("xlsx")){
               workbook =  new XSSFWorkbook(is);
            }
            else if(filePath.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
        return workbook;
    }

    // 检查
    private boolean checkType(String type){
        // 去除前后的空格并转化为小写
        type = type.trim().toLowerCase();
        return type.equals(STRING_TYPE) || type.equals(DOUBLE_TYPE);
    }

    public static String getStringData(Cell cell){
        switch (cell.getCellType()){
            case STRING:
                return StringUtils.trim(cell.getStringCellValue());
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return "";
        }
    }

}
