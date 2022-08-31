package com.dutianze.designpattern.concurrency.readerwriterlock;

import com.dutianze.designpattern.concurrency.readerwriterlock.task.Reader;
import com.dutianze.designpattern.concurrency.readerwriterlock.task.Writer;
import com.dutianze.designpattern.utils.InMemoryAppender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
class ReaderWriterLockTest {

    private InMemoryAppender appender;

    @BeforeEach
    public void setUp() {
        appender = new InMemoryAppender();
    }

    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    @Test
    void readerAndWriterCanOnlyGetTheLockToReadAndWriteOrderly() throws Exception {
        ExecutorService executeService = Executors.newFixedThreadPool(2);
        ReaderWriterLock lock = new ReaderWriterLock();

        Reader reader1 = new Reader("Reader 1", lock.readLock());
        Writer writer1 = new Writer("Writer 1", lock.writeLock());

        executeService.submit(reader1);
        // Let reader1 execute first
        Thread.sleep(150);
        executeService.submit(writer1);

        executeService.shutdown();
        try {
            executeService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Error waiting for ExecutorService shutdown", e);
        }

        assertTrue(appender.logContains("Reader 1 begin"));
        assertTrue(appender.logContains("Reader 1 finish"));
        assertTrue(appender.logContains("Writer 1 begin"));
        assertTrue(appender.logContains("Writer 1 finish"));
    }

    @Test
    void writerAndReaderCanOnlyGetTheLockToReadAndWriteOrderly() throws Exception {
        ExecutorService executeService = Executors.newFixedThreadPool(2);
        ReaderWriterLock lock = new ReaderWriterLock();

        Reader reader1 = new Reader("Reader 1", lock.readLock());
        Writer writer1 = new Writer("Writer 1", lock.writeLock());

        executeService.submit(writer1);
        // Let writer1 execute first
        Thread.sleep(150);
        executeService.submit(reader1);

        executeService.shutdown();
        try {
            executeService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Error waiting for ExecutorService shutdown", e);
        }

        assertTrue(appender.logContains("Writer 1 begin"));
        assertTrue(appender.logContains("Writer 1 finish"));
        assertTrue(appender.logContains("Reader 1 begin"));
        assertTrue(appender.logContains("Reader 1 finish"));
    }

    @Test
    void multipleWritersWillGetTheLockInOrder() throws Exception {
        ExecutorService executeService = Executors.newFixedThreadPool(2);
        ReaderWriterLock lock = new ReaderWriterLock();

        Writer writer1 = spy(new Writer("Writer 1", lock.writeLock()));
        Writer writer2 = spy(new Writer("Writer 2", lock.writeLock()));

        executeService.submit(writer1);
        // Let write1 execute first
        Thread.sleep(150);
        executeService.submit(writer2);

        executeService.shutdown();
        try {
            executeService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Error waiting for ExecutorService shutdown", e);
        }

        assertTrue(appender.logContains("Writer 1 begin"));
        assertTrue(appender.logContains("Writer 1 finish"));
        assertTrue(appender.logContains("Writer 2 begin"));
        assertTrue(appender.logContains("Writer 2 finish"));
    }

    @Test
    void multipleReadersCanGetTheReadLockConcurrently() throws Exception {
        ExecutorService executeService = Executors.newFixedThreadPool(2);
        ReaderWriterLock lock = new ReaderWriterLock();

        Reader reader1 = spy(new Reader("Reader 1", lock.readLock()));
        Reader reader2 = spy(new Reader("Reader 2", lock.readLock()));

        executeService.submit(reader1);
        Thread.sleep(150);
        executeService.submit(reader2);

        executeService.shutdown();
        try {
            executeService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Error waiting for ExecutorService shutdown", e);
        }

        assertTrue(appender.logContains("Reader 1 begin"));
        assertTrue(appender.logContains("Reader 2 begin"));
        assertTrue(appender.logContains("Reader 1 finish"));
        assertTrue(appender.logContains("Reader 2 finish"));
    }
}