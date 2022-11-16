package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/16
 */
@Slf4j
public class GetDirectorySizeTest {

  private final String FILE = "src/test/resources";
  private final Path FILE_PATH = Paths.get(FILE);

  @Test
  void getDirectorySizeJava8() {
    assertDoesNotThrow(() -> {
      long size = 0;
      try (Stream<Path> walk = Files.walk(FILE_PATH)) {
        size = walk
            .filter(Files::isRegularFile)
            .mapToLong(p -> {
              try {
                return Files.size(p);
              } catch (IOException e) {
                System.out.printf("Failed to get size of %s%n%s", p, e);
                return 0L;
              }
            })
            .sum();
      } catch (IOException e) {
        System.out.printf("IO errors %s", e);
      }
      log.info("directory size:{}", size);
    });
  }

  @Test
  void getDirectorySizeCommonIO() {
    assertDoesNotThrow(() -> {
      long size = FileUtils.sizeOfDirectory(FILE_PATH.toFile());
      log.info("directory size:{}", size);
    });
  }

  @Test
  void getDirectorySizeJava7() {
    assertDoesNotThrow(() -> {
      AtomicLong size = new AtomicLong(0);
      Files.walkFileTree(FILE_PATH, new SimpleFileVisitor<>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
          size.addAndGet(attrs.size());
          return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException e) {
          log.error("Failed to get size of {}", file, e);
          return FileVisitResult.CONTINUE;
        }
      });
      log.info("directory size:{}", size.get());
    });
  }

  @Test
  void getDirectorySizeLegacyTest() {
    assertDoesNotThrow(() -> {
      long size = getDirectorySizeLegacy(FILE_PATH.toFile());
      log.info("directory size:{}", size);
    });
  }

  long getDirectorySizeLegacy(File dir) throws IOException {
    long length = 0;
    File[] files = dir.listFiles();
    if (files != null) {
      for (File file : files) {
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(),
            BasicFileAttributes.class);
        if (basicFileAttributes.isRegularFile()) {
          length += basicFileAttributes.size();
        } else {
          length += getDirectorySizeLegacy(file);
        }
      }
    }
    return length;
  }
}
