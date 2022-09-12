package com.dutianze.designpattern.others.executearound;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author dutianze
 * @date 2022/9/10
 */
@FunctionalInterface
public interface FileWriterAction {

  void writeFile(FileWriter writer) throws IOException;
}
