package laborator10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataRepository {
    private static DataRepository instance;
    private final List<SensorData> records;

    private DataRepository() {
        records = new ArrayList<>();
    }

    public static synchronized DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    public synchronized void addData(SensorData dataRecord){
        records.add(dataRecord);
    }

    public synchronized List<SensorData> getRecords() {
        return Collections.unmodifiableList(records);
    }
}
