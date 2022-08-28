package com.dutianze.designpattern.others.roleobject.role;

import com.dutianze.designpattern.others.roleobject.core.CustomerRole;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class BorrowerRole extends CustomerRole {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String borrow() {
        return String.format("Borrower %s wants to get some money.", name);
    }
}
