package com.rckj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author HW
 */
@SpringBootApplication
public class LogProcessingApplication {

    public static void main(String[] args) throws IOException, TimeoutException {
        SpringApplication.run(LogProcessingApplication.class, args);
    }

}
