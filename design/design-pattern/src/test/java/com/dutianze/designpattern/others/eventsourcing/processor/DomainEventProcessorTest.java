package com.dutianze.designpattern.others.eventsourcing.processor;

import com.dutianze.designpattern.others.eventsourcing.domain.Account;
import com.dutianze.designpattern.others.eventsourcing.domain.AccountRepository;
import com.dutianze.designpattern.others.eventsourcing.event.AccountCreateEvent;
import com.dutianze.designpattern.others.eventsourcing.event.MoneyDepositEvent;
import com.dutianze.designpattern.others.eventsourcing.event.MoneyTransferEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/9/11
 */
class DomainEventProcessorTest {

    public static final int ACCOUNT_OF_DAENERYS = 1;
    public static final int ACCOUNT_OF_JON = 2;

    private DomainEventProcessor eventProcessor;
    private AccountRepository accountRepository;

    @BeforeEach
    void initialize() {
        eventProcessor = new DomainEventProcessor();
        accountRepository = new AccountRepository();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @BeforeEach
    @AfterEach
    void cleanup() {
        File file = new File(JsonFileJournal.JSON_FILE_PATH);
        file.delete();
    }

    @Test
    void testStateRecovery() {
        eventProcessor.reset();

        eventProcessor.process(new AccountCreateEvent(
                0, new Date().getTime(), ACCOUNT_OF_DAENERYS, "Daenerys Targaryen"));
        eventProcessor.process(new AccountCreateEvent(
                1, new Date().getTime(), ACCOUNT_OF_JON, "Jon Snow"));

        eventProcessor.process(new MoneyDepositEvent(
                2, new Date().getTime(), ACCOUNT_OF_DAENERYS, BigDecimal.valueOf(100000)));
        eventProcessor.process(new MoneyDepositEvent(
                3, new Date().getTime(), ACCOUNT_OF_JON, BigDecimal.valueOf(100)));

        eventProcessor.process(new MoneyTransferEvent(
                4, new Date().getTime(), BigDecimal.valueOf(520), ACCOUNT_OF_DAENERYS,
                ACCOUNT_OF_JON));

        Account accountOfDaenerysBeforeShotDown = accountRepository.findAccount(ACCOUNT_OF_DAENERYS);
        Account accountOfJonBeforeShotDown = accountRepository.findAccount(ACCOUNT_OF_JON);

        accountRepository.clear();

        eventProcessor = new DomainEventProcessor();
        eventProcessor.recover();

        Account accountOfDaenerysAfterShotDown = accountRepository.findAccount(ACCOUNT_OF_DAENERYS);
        Account accountOfJonAfterShotDown = accountRepository.findAccount(ACCOUNT_OF_JON);

        assertEquals(accountOfDaenerysBeforeShotDown.getAvailable(), accountOfDaenerysAfterShotDown.getAvailable());
        assertEquals(accountOfJonBeforeShotDown.getAvailable(), accountOfJonAfterShotDown.getAvailable());
    }
}