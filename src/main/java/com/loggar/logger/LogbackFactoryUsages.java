package com.loggar.logger;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackFactoryUsages {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        logger.debug("{} aaa", LogbackFactoryUsages.class.getName());
        method2();
    }

    private static void method2() {
        logger.debug("{} bbb");
    }
}
