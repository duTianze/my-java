package com.dutianze.nio;

import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dutianze
 * @date 2022/11/26
 */
public class FileChannelDemo {

  public static void main(String[] args) throws Exception {
    URL resource = FileChannelDemo.class.getResource("/nio-data.txt");
    RandomAccessFile aFile = new RandomAccessFile(resource.getPath(), "rw");
    FileChannel inChannel = aFile.getChannel();

    ByteBuffer buf = ByteBuffer.allocate(48);

    int bytesRead = inChannel.read(buf);
    while (bytesRead != -1) {
      System.out.println("Read " + bytesRead);
      buf.flip();

      while (buf.hasRemaining()) {
        System.out.print((char) buf.get());
      }

      buf.clear();
      bytesRead = inChannel.read(buf);
    }
    aFile.close();
  }
}
