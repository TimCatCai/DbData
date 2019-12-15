package model;

import utils.DataUtils;

public class TextbookSelect {
    private String courseId;
    private String textbookId;
    private int account;

    public TextbookSelect(String courseId, String textbookId, int account) {
        this.courseId = courseId;
        this.textbookId = textbookId;
        this.account = account;
    }

    public String getCourseId() {
        return DataUtils.stringType(courseId);
    }

    public String getTextbookId() {
        return DataUtils.stringType(textbookId);
    }

    public int getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(getCourseId() ,getTextbookId(), String.valueOf(getAccount()));
    }
}
