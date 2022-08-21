package com.dutianze.designpattern.others.tls;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/21
 */
@Getter
public class Result {

    private final List<Date> dateList = new ArrayList<>();
    private final List<String> exceptionList = new ArrayList<>();
}
