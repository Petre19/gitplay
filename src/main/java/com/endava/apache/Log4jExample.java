package com.endava.apache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
    private static final Logger LOGGER= LogManager.getLogger(Log4jExample.class);
    public void doSomething(String s){
        LOGGER.info("doing something with {}",s);
    }
    public static void main(String[] args) {
        Log4jExample l4=new Log4jExample();
        l4.doSomething("Hello");
    }
}
