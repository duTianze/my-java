package com.dutianze.designpattern.others.executearound;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author dutianze
 * @date 2022/9/10
 */
@Slf4j
public class SimpleFileWriter {

    public SimpleFileWriter(String filename, FileWriterAction action) throws IOException {
        log.info("Opening the file");
        try (FileWriter writer = new FileWriter(filename)) {
            log.info("Executing the action");
            action.writeFile(writer);
            log.info("Closing the file");
        }
    }
}
