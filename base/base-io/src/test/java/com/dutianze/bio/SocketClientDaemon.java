package com.dutianze.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/11/22
 */
@Slf4j
public class SocketClientDaemon {

  public static void main(String[] args) throws Exception {
    int clientNumber = 20;
    CountDownLatch countDownLatch = new CountDownLatch(clientNumber);

    for (int index = 0; index < clientNumber; index++, countDownLatch.countDown()) {
      SocketClientRequestThread client = new SocketClientRequestThread(countDownLatch, index);
      new Thread(client).start();
    }

    synchronized (SocketClientDaemon.class) {
      SocketClientDaemon.class.wait(TimeUnit.SECONDS.toMillis(10));
    }
  }

  private record SocketClientRequestThread
      (CountDownLatch countDownLatch, Integer clientIndex) implements Runnable {

    @Override
    public void run() {
      try (Socket socket = new Socket("localhost", 2083);
          OutputStream clientRequest = socket.getOutputStream();
          InputStream clientResponse = socket.getInputStream()) {

        this.countDownLatch.await();

        clientRequest.write(("这是第" + this.clientIndex + " 个客户端的请求。").getBytes());
        clientRequest.flush();

        log.info("第" + this.clientIndex + "个客户端的请求发送完成，等待服务器返回信息");
        int maxLen = 1024;
        byte[] contextBytes = new byte[maxLen];
        int realLen;
        StringBuilder message = new StringBuilder();

        while ((realLen = clientResponse.read(contextBytes, 0, maxLen)) != -1) {
          message.append(new String(contextBytes, 0, realLen));
        }

        log.info("接收到来自服务器的信息:" + message);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
    }
  }
}
