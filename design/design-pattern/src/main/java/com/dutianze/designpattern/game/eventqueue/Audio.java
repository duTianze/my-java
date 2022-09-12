package com.dutianze.designpattern.game.eventqueue;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Slf4j
public class Audio {

  private static final Audio INSTANCE = new Audio();

  private int headIndex;
  private int tailIndex;
  private volatile Thread updateThread = null;
  private static final int MAX_PENDING = 16;
  private final AudioResource[] pendingAudio = new AudioResource[MAX_PENDING];

  private Audio() {
  }

  public static Audio getInstance() {
    return INSTANCE;
  }

  public synchronized void stopService() throws InterruptedException {
    if (updateThread == null) {
      return;
    }
    updateThread.interrupt();
    updateThread.join();
    updateThread = null;
  }

  public synchronized boolean isServiceRunning() {
    return updateThread != null && updateThread.isAlive();
  }

  public void init() {
    if (updateThread == null) {
      updateThread = new Thread(() -> {
        while (!Thread.currentThread().isInterrupted()) {
          update();
        }
      });
    }
    startThread();
  }

  private synchronized void startThread() {
    if (!updateThread.isAlive()) {
      updateThread.start();
      headIndex = 0;
      tailIndex = 0;
    }
  }

  /**
   * adds a new audio into the queue
   *
   * @param resource is the audio resource for the method
   * @param volume   is the level of the audio's volume
   */
  public void playSound(URL resource, float volume) {
    init();
    // Walk the pending requests.
    for (int i = headIndex; i != tailIndex; i = (i + 1) % MAX_PENDING) {
      AudioResource playMessage = pendingAudio[i];
      if (playMessage.getResource() == resource) {
        // Use the larger of the two volumes.
        playMessage.setVolume(Math.max(volume, playMessage.getVolume()));
        // Don't need to enqueue.
        return;
      }
    }
    pendingAudio[tailIndex] = new AudioResource(resource, volume);
    tailIndex = (tailIndex + 1) % MAX_PENDING;
  }

  /**
   * takes the audio from the queue and plays it
   */
  private void update() {
    // If there are no pending requests, do nothing.
    if (headIndex == tailIndex) {
      return;
    }
    try {
      URL resource = pendingAudio[headIndex].getResource();
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(resource);
      headIndex++;
      Clip clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.start();
    } catch (LineUnavailableException e) {
      log.info("Error occoured while loading the audio: The line is unavailable", e);
    } catch (IOException e) {
      log.info("Input/Output error while loading the audio", e);
    } catch (IllegalArgumentException | UnsupportedAudioFileException e) {
      log.info("The system doesn't support the sound: " + e.getMessage(), e);
    }
  }
}
