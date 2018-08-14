package com.config.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j {
    private final Class<?> aClass;
    private Logger logger;

    log4j(Class<?> aClass) {
        this.aClass = aClass;
        this.logger = LogManager.getLogger(this.aClass);
    }

    public void debug(String message) {
        logger.debug(aClass.getCanonicalName() + ": " + message);
    }

    public void error(String message) {
        logger.error(aClass.getCanonicalName() + ": " + message);
    }

    public void trace(String message) {
        logger.trace(aClass.getCanonicalName() + ": " + message);
    }

    public void warn(String message) {
        logger.warn(aClass.getCanonicalName() + ": " + message);
    }

    public void fatal(String message) {
        logger.fatal(aClass.getCanonicalName() + ": " + message);
    }

    public void info(String message) {
        logger.info(aClass.getCanonicalName() + ": " + message);
    }

}
