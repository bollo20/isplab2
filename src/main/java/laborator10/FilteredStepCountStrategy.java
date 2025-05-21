package laborator10;

import java.util.List;

public class FilteredStepCountStrategy implements StepCountStrategy {

    @Override
    public void consumeMessage(SensorData sample) {
        DataRepository.getInstance().addData(sample);
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> data = DataRepository.getInstance().getRecords();
        int total = 0;

        for (int i = 0; i < data.size(); i++) {
            SensorData current = data.get(i);
            if (current.getStepsCount() <= 0) {
                continue;
            }

            long currentTimestamp = current.getTimestamp();
            int stepsInLastMinute = 0;

            for (int j = 0; j < i; j++) {
                SensorData previous = data.get(j);
                if (currentTimestamp - previous.getTimestamp() <= 60000) { // 60 sec * 1000 ms
                    stepsInLastMinute += previous.getStepsCount();
                }
            }

            if (stepsInLastMinute <= 1000) {
                total += current.getStepsCount();
            }
        }

        return total;
    }

    @Override
    public String getStrategyDescription() {
        return "FilteredStepCountStrategy: sums positive step counts if less than 1000 steps in last minute";
    }
}

