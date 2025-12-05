package logging_program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String[] args) {

        final Logger logger = LogManager.getLogger(Main.class);

        Worker worker = new Worker();

        int cores = Runtime.getRuntime().availableProcessors();
        logger.debug("Cores: " + cores);

        ExecutorService service = Executors.newFixedThreadPool(cores);

        service.execute(worker);
        service.execute(worker);
        service.execute(worker);
        service.execute(worker);

        service.shutdown();
    }
}
