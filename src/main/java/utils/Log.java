package utils;

import org.apache.logging.log4j.*;

public class Log {

    private static Logger log = LogManager.getLogger(Log.class);

    public static void info(String msg) {
        log.info(msg);
    }

    public static void error(String msg) {
        log.error(msg);
    }
}