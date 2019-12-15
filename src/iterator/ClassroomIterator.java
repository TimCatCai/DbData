package iterator;

import iterator.AbstractExcelRowIterator;
import model.Classroom;
import org.apache.commons.lang3.RandomUtils;
import utils.DataUtils;

public class ClassroomIterator extends AbstractExcelRowIterator<Classroom> {

    @Override
    public Classroom next() {
        super.index ++;
        String classroomId = DataUtils.addLeadingZero(index, "0000000000");
        String location = generateLocation();
        int capability = generateCapability();
        return new Classroom(classroomId, location, capability);
    }

    private String generateLocation(){
        // 假设每个教学楼有200个教室
        int building = index / 200;
        int level = (index % 200) / 40 + 1;
        String levelPattern = level + "00";
        int serialNum = (index % 200) % 40;

        String accuracyPosition = DataUtils.addLeadingZero(serialNum, levelPattern);
        switch (building){
            case 0:
                return "教一" + accuracyPosition;
            case 1:
                return "教二" + accuracyPosition;
            case 2:
                return "教三" + accuracyPosition;
            case 3:
                return "教四" + accuracyPosition;
            default:
                return "Unknown";
        }
    }

    private int generateCapability(){
        // 假设有四种类型的教室
        switch (RandomUtils.nextInt(0,4)){
            case 0:
                return 50;
            case 1:
                return 80;
            case 2:
                return 100;
            case 3:
                return 200;
            default:
                return 0;
        }
    }
    @Override
    public boolean hasNext() {
        // 假设教室总量是800个
        int classroomNum = 800 - 1;
        return index < classroomNum;
    }
}
