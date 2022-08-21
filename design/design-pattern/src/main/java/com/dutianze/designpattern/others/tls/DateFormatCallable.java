package com.dutianze.designpattern.others.tls;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

/**
 * @author dutianze
 * @date 2022/8/21
 */
@Slf4j
public class DateFormatCallable implements Callable<Result> {

    private final ThreadLocal<DateFormat> df;
    //private DateFormat df;
    private final String dateValue;

    public DateFormatCallable(String inDateFormat, String inDateValue) {
        //this.df = new SimpleDateFormat(inDateFormat);
        this.df = ThreadLocal.withInitial(() -> new SimpleDateFormat(inDateFormat));
        this.dateValue = inDateValue;
    }

    @Override
    public Result call() {
        log.info(Thread.currentThread() + " started executing...");
        Result result = new Result();
        IntStream.rangeClosed(1, 5).forEach(i -> {
            try {
                result.getDateList().add(df.get().parse(dateValue));
                //result.getDateList().add(df.parse(this.dateValue));
            } catch (Exception e) {
                result.getExceptionList().add(e.getClass() + ": " + e.getMessage());
            }
        });
        log.info("{} finished processing part of the thread", Thread.currentThread());
        return result;
    }
}
