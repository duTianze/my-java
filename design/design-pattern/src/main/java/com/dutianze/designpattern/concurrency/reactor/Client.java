package com.dutianze.designpattern.concurrency.reactor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO 待学习
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="http://projectreactor.io/">Spring Reactor</a></li>
 * <li><a href="https://www.dre.vanderbilt.edu/~schmidt/PDF/Reactor.pdf">Douglas C. Schmidt - Reactor</a></li>
 * <li><a href="http://gee.cs.oswego.edu/dl/cpjslides/nio.pdf">Doug Lea - Scalable IO in Java</a></li>
 * <li><a href="http://netty.io/">Netty</a></li>
 * </ul>
 * <p>
 * Represents the clients of Reactor pattern. Multiple clients are run concurrently and send logging
 * requests to Reactor.
 *
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class Client {

  private final ExecutorService service = Executors.newFixedThreadPool(4);

  /**
   * Starts the logging clients.
   *
   * @throws IOException if any I/O error occurs.
   */
  public void start() throws IOException {
    log.info("Starting logging clients");
    service.execute(new TcpLoggingClient("Client 1", 16666));
    service.execute(new TcpLoggingClient("Client 2", 16667));
    service.execute(new UdpLoggingClient("Client 3", 16668));
    service.execute(new UdpLoggingClient("Client 4", 16669));
  }

  /**
   * Stops logging clients. This is a blocking call.
   */
  public void stop() {
    service.shutdown();
    if (!service.isTerminated()) {
      service.shutdownNow();
      try {
        service.awaitTermination(1000, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        log.error("exception awaiting termination", e);
      }
    }
    log.info("Logging clients stopped");
  }

  private static void artificialDelayOf(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      log.error("sleep interrupted", e);
    }
  }

  /**
   * A logging client that sends requests to Reactor on TCP socket.
   */
  static class TcpLoggingClient implements Runnable {

    private final int serverPort;
    private final String clientName;

    /**
     * Creates a new TCP logging client.
     *
     * @param clientName the name of the client to be sent in logging requests.
     * @param serverPort the port on which client will send logging requests.
     */
    public TcpLoggingClient(String clientName, int serverPort) {
      this.clientName = clientName;
      this.serverPort = serverPort;
    }

    @Override
    public void run() {
      try (Socket socket = new Socket(InetAddress.getLocalHost(), serverPort)) {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        sendLogRequests(writer, socket.getInputStream());
      } catch (IOException e) {
        log.error("error sending requests", e);
        throw new RuntimeException(e);
      }
    }

    private void sendLogRequests(PrintWriter writer, InputStream inputStream) throws IOException {
      for (int i = 0; i < 4; i++) {
        writer.println(clientName + " - Log request: " + i);
        writer.flush();

        byte[] data = new byte[1024];
        int read = inputStream.read(data, 0, data.length);
        if (read == 0) {
          log.info("Read zero bytes");
        } else {
          log.info(new String(data, 0, read));
        }

        artificialDelayOf(100);
      }
    }

  }

  /**
   * A logging client that sends requests to Reactor on UDP socket.
   */
  static class UdpLoggingClient implements Runnable {

    private final String clientName;
    private final InetSocketAddress remoteAddress;

    /**
     * Creates a new UDP logging client.
     *
     * @param clientName the name of the client to be sent in logging requests.
     * @param port       the port on which client will send logging requests.
     * @throws UnknownHostException if localhost is unknown
     */
    public UdpLoggingClient(String clientName, int port) throws UnknownHostException {
      this.clientName = clientName;
      this.remoteAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
    }

    @Override
    public void run() {
      try (DatagramSocket socket = new DatagramSocket()) {
        for (int i = 0; i < 4; i++) {

          String message = clientName + " - Log request: " + i;
          byte[] bytes = message.getBytes();
          DatagramPacket request = new DatagramPacket(bytes, bytes.length, remoteAddress);

          socket.send(request);

          byte[] data = new byte[1024];
          DatagramPacket reply = new DatagramPacket(data, data.length);
          socket.receive(reply);
          if (reply.getLength() == 0) {
            log.info("Read zero bytes");
          } else {
            log.info(new String(reply.getData(), 0, reply.getLength()));
          }

          artificialDelayOf(100);
        }
      } catch (IOException e1) {
        log.error("error sending packets", e1);
      }
    }
  }
}
