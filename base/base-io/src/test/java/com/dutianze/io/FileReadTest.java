package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/14
 */
@Slf4j
public class FileReadTest {

  private final Path FILE_PATH = Paths.get("src/test/resources/fileRead.txt");

  @Test
  void readFileJava7() {
    assertDoesNotThrow(() -> {
      byte[] bytes = Files.readAllBytes(FILE_PATH);
      String content = new String(bytes, StandardCharsets.UTF_8);
      log.info(content);

      List<String> lines = Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8);
      lines.forEach(log::info);
    });
  }

  @Test
  void readFileJava8() {
    assertDoesNotThrow(() -> {
      // foreach
      System.out.println("foreach");
      try (Stream<String> lines = Files.lines(FILE_PATH)) {
        lines.forEach(log::info);
      }

      // parallel
      System.out.println("parallel");
      try (Stream<String> lines = Files.lines(FILE_PATH)) {
        lines.parallel().forEach(log::info);
      }

      // preserve order
      System.out.println("preserve order");
      try (Stream<String> lines = Files.lines(FILE_PATH)) {
        lines.parallel().forEachOrdered(log::info);
      }
    });
  }

  @Test
  void readFileJava11() {
    assertDoesNotThrow(() -> {
      String content = Files.readString(FILE_PATH);
      log.info(content);
    });
  }

  @Test
  void readFileBufferedReader() {
    assertDoesNotThrow(() -> {
      try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH.toFile()))) {
        for (String line; (line = br.readLine()) != null; ) {
          log.info(line);
        }
      }

      try (BufferedReader br = Files.newBufferedReader(FILE_PATH)) {
        String line;
        while ((line = br.readLine()) != null) {
          log.info(line);
        }
      }
    });
  }

  @Test
  void readFileScanner() {
    assertDoesNotThrow(() -> {
      try (Scanner sc = new Scanner(new FileReader(FILE_PATH.toFile()))) {
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          log.info(line);
        }
      }
    });
  }
}
