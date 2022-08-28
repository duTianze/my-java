package com.dutianze.designpattern.others.retry;

import com.dutianze.designpattern.others.retry.exception.BusinessException;
import com.dutianze.designpattern.others.retry.exception.CustomerNotFoundException;
import com.dutianze.designpattern.others.retry.exception.DatabaseNotAvailableException;
import com.dutianze.designpattern.others.retry.retry.Retry;
import com.dutianze.designpattern.others.retry.retry.RetryExponentialBackoff;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
class FindCustomerTest {

    @Test
    void usageWithRetry() {
        assertDoesNotThrow(() -> {
            final Retry<String> retry = new Retry<>(
                    new FindCustomer("123", new CustomerNotFoundException("not found")),
                    3, 100, e -> CustomerNotFoundException.class.isAssignableFrom(e.getClass())
            );
            final String customerId = retry.perform();
            log.info(String.format(
                    "However, retrying the operation while ignoring a recoverable error will eventually yield "
                    + "the result %s after a number of attempts %s", customerId, retry.attempts()
            ));
        });
    }

    @Test
    void usageWithRetryExponentialBackoff() {
        assertDoesNotThrow(() -> {
            final RetryExponentialBackoff<String> retry = new RetryExponentialBackoff<>(
                    new FindCustomer("123", new CustomerNotFoundException("not found")),
                    3, 300, e -> CustomerNotFoundException.class.isAssignableFrom(e.getClass())
            );
            final var customerId = retry.perform();
            log.info(String.format(
                    "However, retrying the operation while ignoring a recoverable error will eventually yield "
                    + "the result %s after a number of attempts %s", customerId, retry.attempts()
            ));
        });
    }

    @Test
    void returnsTheGivenResultWithNoExceptions() throws Exception {
        assertThat(new FindCustomer("123").perform(), is("123"));
    }

    @Test
    void throwsTheGivenException() {
        FindCustomer findCustomer = new FindCustomer("123", new BusinessException("test"));
        assertThrows(BusinessException.class, findCustomer::perform);
    }

    @Test
    void shouldFirstThrowTheGivenExceptionsThenReturnTheGivenResult() throws Exception {
        final FindCustomer op = new FindCustomer("123",
                                                 new CustomerNotFoundException("not found"),
                                                 new DatabaseNotAvailableException("not available"));
        try {
            op.perform();
        } catch (CustomerNotFoundException e) {
            //ignore
        }
        try {
            op.perform();
        } catch (DatabaseNotAvailableException e) {
            //ignore
        }

        assertThat(op.perform(), is("123"));
    }

    @Test
    void shouldContainAllErrorsThrown() {
        final BusinessException e = new BusinessException("unhandled");
        final RetryExponentialBackoff<String> retry = new RetryExponentialBackoff<>(
                () -> {
                    throw e;
                }, 2, 0
        );
        try {
            retry.perform();
        } catch (BusinessException ex) {
            //ignore
        }

        assertThat(retry.errors(), hasItem(e));
    }

    @Test
    void exceptionsWillNotBeIgnoredSoNoAttempts() {
        final BusinessException e = new BusinessException("unhandled");
        final RetryExponentialBackoff<String> retry = new RetryExponentialBackoff<>(
                () -> {
                    throw e;
                }, 2, 0
        );
        try {
            retry.perform();
        } catch (BusinessException ex) {
            //ignore
        }

        assertThat(retry.attempts(), is(1));
    }

    @Test
    void exceptionsWillBeIgnoredSoAttempts() {
        final CustomerNotFoundException e = new CustomerNotFoundException("customer not found");
        final RetryExponentialBackoff<String> retry = new RetryExponentialBackoff<>(
                () -> {
                    throw e;
                }, 2, 0, ex -> CustomerNotFoundException.class.isAssignableFrom(ex.getClass())
        );
        try {
            retry.perform();
        } catch (BusinessException ex) {
            //ignore
        }

        assertThat(retry.attempts(), is(2));
    }
}