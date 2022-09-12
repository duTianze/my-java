package com.dutianze.designpattern.concurrency.reactor;

import com.dutianze.designpattern.concurrency.reactor.framework.AbstractNioChannel;
import com.dutianze.designpattern.concurrency.reactor.framework.ChannelHandler;
import com.dutianze.designpattern.concurrency.reactor.framework.NioDatagramChannel;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import lombok.extern.slf4j.Slf4j;

/**
 * Logging server application logic. It logs the incoming requests on standard console and returns a
 * canned acknowledgement back to the remote peer.
 *
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class LoggingHandler implements ChannelHandler {

  private static final byte[] ACK = "Data logged successfully".getBytes();

  /**
   * Decodes the received data and logs it on standard console.
   */
  @Override
  public void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key) {
    /*
     * As this handler is attached with both TCP and UDP channels we need to check whether the data
     * received is a ByteBuffer (from TCP channel) or a DatagramPacket (from UDP channel).
     */
    if (readObject instanceof ByteBuffer) {
      doLogging((ByteBuffer) readObject);
      sendReply(channel, key);
    } else if (readObject instanceof NioDatagramChannel.DatagramPacket datagram) {
      doLogging(datagram.getData());
      sendReply(channel, datagram, key);
    } else {
      throw new IllegalStateException("Unknown data received");
    }
  }

  private static void sendReply(
      AbstractNioChannel channel,
      NioDatagramChannel.DatagramPacket incomingPacket,
      SelectionKey key
  ) {
    /*
     * Create a reply acknowledgement datagram packet setting the receiver to the sender of incoming
     * message.
     */
    NioDatagramChannel.DatagramPacket replyPacket = new NioDatagramChannel.DatagramPacket(
        ByteBuffer.wrap(ACK));
    replyPacket.setReceiver(incomingPacket.getSender());

    channel.write(replyPacket, key);
  }

  private static void sendReply(AbstractNioChannel channel, SelectionKey key) {
    ByteBuffer buffer = ByteBuffer.wrap(ACK);
    channel.write(buffer, key);
  }

  private static void doLogging(ByteBuffer data) {
    // assuming UTF-8 :(
    log.info(new String(data.array(), 0, data.limit()));
  }
}
