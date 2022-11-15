package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/15
 */
public class FileFindTest {

  @Test
  void findByFileNameTest() {
    assertDoesNotThrow(() -> {
      String fileName = "FileFindTest.java";

      List<Path> result;
      try (Stream<Path> pathStream = Files.find(Paths.get("."), Integer.MAX_VALUE,
          (p, basicFileAttributes) -> {
            // if directory or no-read permission, ignore
            if (Files.isDirectory(p) || !Files.isReadable(p)) {
              return false;
            }
            return p.getFileName().toString().equalsIgnoreCase(fileName);
          })
      ) {
        result = pathStream.collect(Collectors.toList());
      }

      result.forEach(System.out::println);
    });
  }

  @Test
  void findByFileSizeTest() {
    assertDoesNotThrow(() -> {
      long fileSize = 1024 * 4;

      List<Path> result;
      try (Stream<Path> pathStream = Files.find(Paths.get("."), Integer.MAX_VALUE,
          (p, basicFileAttributes) -> {
            try {
              if (Files.isDirectory(p)) {
                return false;
              }
              return Files.size(p) >= fileSize;
            } catch (IOException e) {
              e.printStackTrace();
            }
            return false;
          })
      ) {
        result = pathStream.collect(Collectors.toList());
      }

      for (Path p : result) {
        System.out.printf("%-40s [fileSize]: %,d%n", p, Files.size(p));
      }
    });
  }

  @Test
  void findByLastModifiedTime() {
    assertDoesNotThrow(() -> {
      Instant instant = Instant.now().minus(1, ChronoUnit.DAYS);

      List<Path> result;
      try (Stream<Path> pathStream = Files.find(Paths.get("."), Integer.MAX_VALUE,
          (p, basicFileAttributes) -> {
            if (Files.isDirectory(p) || !Files.isReadable(p)) {
              return false;
            }

            FileTime fileTime = basicFileAttributes.lastModifiedTime();
            int i = fileTime.toInstant().compareTo(instant);
            return i > 0;
          })
      ) {
        result = pathStream.collect(Collectors.toList());
      }

      DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
      for (Path p : result) {
        BasicFileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
        FileTime time = attrs.lastModifiedTime();
        LocalDateTime ldt = time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.printf("%-40s [%s]%n", p, ldt.format(DATE_FORMATTER));
      }
    });
  }
}
