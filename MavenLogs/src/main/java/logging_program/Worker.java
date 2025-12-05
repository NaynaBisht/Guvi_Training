package logging_program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker implements Runnable {

    final Logger logger = LogManager.getLogger(Worker.class);

    @Override
    public void run() {
        logger.trace("worker is running");
    }
}
