package laborator10;

import laborator10.DataRepository;
import laborator10.SensorData;
import laborator10.StepCountStrategy;

import java.util.List;

public class BasicStepCountStrategy implements StepCountStrategy {

    @Override
    public void consumeMessage(SensorData sample) {
        DataRepository.getInstance().addData(sample);
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> data = DataRepository.getInstance().getRecords();
        int total = 0;
        for (SensorData d : data) {
            total += d.getStepsCount();
        }
        return total;
    }

    @Override
    public String getStrategyDescription() {
        return "BasicStepCountStrategy: sums all step counts";
    }
}

