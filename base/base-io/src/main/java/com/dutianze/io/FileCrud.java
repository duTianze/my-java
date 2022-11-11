package com.dutianze.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author dutianze
 * @date 2022/11/11
 */
public class FileCrud {

  public void createFile() throws IOException {
    String content = "test1";
    Path path = Paths.get("/home/mkyong/test/aaa.txt");
    Files.writeString(path, content);
  }
}
