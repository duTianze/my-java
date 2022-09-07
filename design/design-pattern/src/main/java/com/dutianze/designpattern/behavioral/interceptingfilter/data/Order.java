package com.dutianze.designpattern.behavioral.interceptingfilter.data;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dutianze
 * @date 2022/9/8
 */
@Data
@AllArgsConstructor
public class Order {

    private String name;
    private String contactNumber;
    private String address;
    private String depositNumber;
    private String orderItem;
}
