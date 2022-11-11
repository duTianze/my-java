package com.dutianze.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/12
 */
class FileCrudTest {

  private final String FILE_NAME = "src/test/resources/fileToCreate.txt";

  @BeforeEach
  public void cleanUpFiles() {
    File targetFile = new File(FILE_NAME);
    targetFile.delete();
  }

  @Test
  void createFile() throws IOException {
    Path newFilePath = Paths.get(FILE_NAME);
    Files.createFile(newFilePath);
  }
}