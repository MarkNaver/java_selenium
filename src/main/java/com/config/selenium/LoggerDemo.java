package com.config.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {
    public static final Logger log = LogManager.getLogger(LoggerDemo.class.getName());

    public static void main(String[] args) {
        log.debug("Debug message logged");
        log.error("Error message logged");
    }
}
