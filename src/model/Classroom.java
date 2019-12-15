package model;

import utils.DataUtils;

public class Classroom {
    private String mClassroomId;
    private String mLocation;
    private int mCapability;

    public Classroom(String mClassroomId, String mLocation, int mCapability) {
        this.mClassroomId = mClassroomId;
        this.mLocation = mLocation;
        this.mCapability = mCapability;
    }

    @Override
    public String toString() {
        return DataUtils.formatOneTuple(
                DataUtils.stringType(mClassroomId),
                DataUtils.stringType(mLocation),
                String.valueOf(mCapability)
        );
    }
}
