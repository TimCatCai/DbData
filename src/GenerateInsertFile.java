import iterator.AbstractExcelRowIterator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class GenerateInsertFile {
    public static <RowType, ExcelIterator extends AbstractExcelRowIterator<RowType>>
    void generateInsertFile(ExcelIterator it, String table, String filePath, String savePath) {
        Workbook workbook = ExcelUtils.getWorkbook(filePath);
        // 这里只取第一个工作簿
        Sheet sheet = workbook.getSheetAt(0);
        it.setSheet(sheet);
        String insertHead = "INSERT INTO " + table + " VALUES";
        List<String> tupleValues = new ArrayList<>();
        tupleValues.add(insertHead);
        RowType aRow;
        while (it.hasNext()) {
            aRow = it.next();
            tupleValues.add(aRow.toString() + ",");
        }

        if (tupleValues.size() >= 2) {
            // 去掉最后一个元组数据的逗号，并加上分号结束
            String last = tupleValues.get(tupleValues.size() - 1);
            last = StringUtils.substring(last, 0, last.length() - 1) + ";";
            tupleValues.set(tupleValues.size() - 1, last);

            // 将得到的数据写入文件
            File saveFile = new File(savePath);
            try {
                FileUtils.writeLines(saveFile, tupleValues);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
