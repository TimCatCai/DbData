package model;

import utils.DataUtils;

public class Textbook {
    private String textbookId;
    private String textbookName;
    private String press;
    private int price;
    private String publishDay;

    public Textbook(String textbookId, String getTextbookName, String press, int price, String publishDay) {
        this.textbookId = textbookId;
        this.textbookName = getTextbookName;
        this.press = press;
        this.price = price;
        this.publishDay = publishDay;
    }

    public String getTextbookId() {
        return DataUtils.stringType(textbookId);
    }

    public String getTextbookName() {
        return DataUtils.stringType(textbookName);
    }

    public String getPress() {
        return DataUtils.stringType(press);
    }

    public int getPrice() {
        return price;
    }

    public String getPublishDay() {
        if(publishDay.equals("null")){
            return publishDay;
        }
        return DataUtils.dateType(publishDay);
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(getTextbookId(),getTextbookName(),getPress(),
                String.valueOf(getPrice()),getPublishDay());
    }
}
