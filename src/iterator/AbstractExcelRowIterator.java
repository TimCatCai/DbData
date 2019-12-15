package iterator;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class AbstractExcelRowIterator<T> implements Iterator<T>{
    protected Random random = new Random(System.currentTimeMillis());
    protected Sheet sheet;
    protected int index;
    protected List<Sheet> compareSheets;
    public AbstractExcelRowIterator(Sheet sheet){
        this.sheet = sheet;
        index = 0;
    }
    public AbstractExcelRowIterator(){

    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    @Override
    public boolean hasNext() {
        return index < sheet.getLastRowNum();
    }

    public void setCompareSheets(List<Sheet> compareSheets) {
        this.compareSheets = compareSheets;
    }

}
