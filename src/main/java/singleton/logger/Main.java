package singleton.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.setFileName("new_log.txt");

        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close();

        logger.write("logging line 1");
        logger.write("logging line 2");
        logger.write("logging line 3");
        logger.close();


    }
}
