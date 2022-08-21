package com.dutianze.designpattern.others.tls;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author dutianze
 * @date 2022/8/21
 */
class DateFormatCallableTest {

    private static class StringArrayList extends ArrayList<String> {
    }

    private static final Result[] result = new Result[4];
    private static final List<String>[] createdDateValues = new StringArrayList[4];
    private final List<String> expectedDateValues =
            List.of("15.11.2015", "15.11.2015", "15.11.2015", "15.11.2015", "15.11.2015");

    @BeforeAll
    public static void setup() {
        DateFormatCallable callableDf = new DateFormatCallable("dd/MM/yyyy", "15/12/2015");
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Result> futureResult1 = executor.submit(callableDf);
        Future<Result> futureResult2 = executor.submit(callableDf);
        Future<Result> futureResult3 = executor.submit(callableDf);
        Future<Result> futureResult4 = executor.submit(callableDf);
        try {
            result[0] = futureResult1.get();
            result[1] = futureResult2.get();
            result[2] = futureResult3.get();
            result[3] = futureResult4.get();
            for (int i = 0; i < result.length; i++) {
                createdDateValues[i] = convertDatesToString(result[i]);
            }
        } catch (Exception e) {
            fail("Setup failed: " + e);
        }
        executor.shutdown();
    }

    @Test
    void allResultShouldCorrect() {
        Arrays.stream(createdDateValues)
              .forEach(createdDateValue -> assertEquals(expectedDateValues, createdDateValue));
    }

    @Test
    void dateListShouldFive() {
        Arrays.stream(result)
              .forEach(value -> assertEquals(5, value.getDateList().size()));
    }

    @Test
    void exceptionListShouldZero() {
        Arrays.stream(result)
              .forEach(value -> assertEquals(0, value.getExceptionList().size()));
    }

    private static List<String> convertDatesToString(Result res) {
        if (res == null || res.getDateList() == null || res.getDateList().size() == 0) {
            return null;
        }
        StringArrayList returnList = new StringArrayList();
        for (Date dt : res.getDateList()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            returnList.add(
                    cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR));
        }
        return returnList;
    }
}