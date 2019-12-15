package model;

import utils.DataUtils;

public class Teacher {
    private String mTeacherId;
    private String mName;
    private String mSex;
    private String departmentId;
    private String mBirthDay;
    private String mJoinWorkDate;

    public Teacher(String mTeacherId, String mName, String mSex, String departmentId, String birthDay, String joinWorkDate) {
        this.mTeacherId = mTeacherId;
        this.mName = mName;
        this.mSex = mSex;
        this.departmentId = departmentId;
        this.mBirthDay = birthDay;
        this.mJoinWorkDate = joinWorkDate;
    }

    public String getTeacherId() {
        return mTeacherId;
    }

    public String getName() {
        return mName;
    }

    public String getSex() {
        return mSex;
    }

    public String getBirthDay() {
        return DataUtils.dateType(mBirthDay);
    }

    public String getJoinWorkDate() {
        return DataUtils.dateType(mJoinWorkDate);
    }

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(
                DataUtils.stringType(getTeacherId()),
                DataUtils.stringType(getName()),
                DataUtils.stringType(getSex()),
                DataUtils.stringType(getDepartmentId()),
                getBirthDay(),
                getJoinWorkDate()
                );
    }
}
