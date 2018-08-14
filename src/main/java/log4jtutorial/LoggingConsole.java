package log4jtutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingConsole {
    private static final Logger log = LogManager.getLogger(LoggingConsole.class.getName());

    public static void main(String[] args) {
//        log.trace("123");
//        log.debug("123");
        log.info("哈哈哈");
//        log.error("123");
//        log.fatal("123");
    }

}
