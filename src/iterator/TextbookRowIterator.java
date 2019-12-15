package iterator;

import model.Textbook;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import utils.DataUtils;
import utils.ExcelUtils;

public class TextbookRowIterator extends AbstractExcelRowIterator<Textbook> {
    @Override
    public Textbook next() {
        super.index++;
        Row row = sheet.getRow(index);
        String textbookId = ExcelUtils.getStringData(row.getCell(0));
        String textbookName = StringUtils.trim(row.getCell(1).getStringCellValue());
        String press = StringUtils.trim(row.getCell(2).getStringCellValue());
        int price = RandomUtils.nextInt(20, 60);
        String publishDay = ExcelUtils.getStringData(row.getCell(3));
        // 只取年份
        publishDay = StringUtils.substring(publishDay,0, 4);
        if(publishDay.isEmpty()){
            publishDay = "null";
        }else{
            publishDay = DataUtils.dateFormat(Integer.parseInt(publishDay), 1, 1);
        }

        return new Textbook(textbookId,textbookName, press, price, publishDay);
    }

}
