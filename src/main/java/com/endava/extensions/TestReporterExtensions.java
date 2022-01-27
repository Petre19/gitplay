package com.endava.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestReporterExtensions implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private  static final Logger LOGGER= LogManager.getLogger(TestReporterExtensions.class);

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext){
        LOGGER.info("\n starting test{}/{}",extensionContext.getTestClass().get().getSimpleName(),extensionContext.getDisplayName());
    }
    @Override
    public void afterTestExecution(ExtensionContext extensionContext){
        LOGGER.info("\nfinishing test{}/{} ",extensionContext.getTestClass().get().getSimpleName(),extensionContext.getDisplayName());
    }
}
