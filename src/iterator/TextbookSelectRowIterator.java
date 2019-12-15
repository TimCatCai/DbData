package iterator;

import model.TextbookSelect;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.ss.usermodel.Row;
import utils.ExcelUtils;

public class TextbookSelectRowIterator extends AbstractExcelRowIterator<TextbookSelect>  {
    @Override
    public TextbookSelect next() {
        super.index++;
        Row row = sheet.getRow(index);
        String courseId = ExcelUtils.getStringData(row.getCell(0));
        String textbookId = ExcelUtils.getStringData(row.getCell(1));
        int account = RandomUtils.nextInt(30, 300);
        return new TextbookSelect(courseId, textbookId, account);
    }
}
