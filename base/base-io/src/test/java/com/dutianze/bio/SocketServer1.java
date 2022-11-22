package com.dutianze.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/11/22
 */
@Slf4j
public class SocketServer1 {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(2083)) {
      while (true) {
        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        int sourcePort = socket.getPort();
        int maxLen = 2048;
        byte[] contextBytes = new byte[maxLen];

        int realLen = in.read(contextBytes, 0, maxLen);

        String message = new String(contextBytes, 0, realLen);
        log.info("服务器收到来自于端口: " + sourcePort + "的信息: " + message);
        TimeUnit.SECONDS.sleep(1);
        out.write(("[响应:" + message + "]").getBytes());

        out.close();
        in.close();
        socket.close();
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
