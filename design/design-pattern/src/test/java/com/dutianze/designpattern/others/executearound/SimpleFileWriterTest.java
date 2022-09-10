package com.dutianze.designpattern.others.executearound;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dutianze
 * @date 2022/9/10
 */
@Slf4j
class SimpleFileWriterTest {

    @BeforeEach
    @AfterEach
    void cleanup() {
        File file = new File("testFile.txt");
        boolean deleted = file.delete();
        assertTrue(deleted);
    }

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            FileWriterAction writeHello = writer -> {
                writer.write("Gandalf was here");
            };
            new SimpleFileWriter("testFile.txt", writeHello);

            // print the file contents
            try (Scanner scanner = new Scanner(new File("testFile.txt"))) {
                while (scanner.hasNextLine()) {
                    log.info(scanner.nextLine());
                }
            }
        });
    }
}