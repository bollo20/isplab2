package laborator10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MainApp {

    private static final Logger log = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {

        log.info("Choose a strategy: type 'basic or 'filtered'");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        // TODO get instance to data repository
        //DataRepository dataRepository =  ...

        // TODO: obtain a strategy for strategyType, and instantiate aggregator
        //DataAggregator aggregator = new DataAggregator(Utils.getStrategy(strategyType));

        /* TODO: uncomment
        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));

        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));

        System.out.println("====================================================");
        aggregator.receive(dataRepository);
        System.out.println( aggregator.getResults());
        System.out.println("====================================================");
         */

    }
}
