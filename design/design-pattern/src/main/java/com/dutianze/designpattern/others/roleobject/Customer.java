package com.dutianze.designpattern.others.roleobject;

import com.dutianze.designpattern.others.roleobject.core.CustomerCore;
import com.dutianze.designpattern.others.roleobject.role.Role;

import java.util.Arrays;
import java.util.Optional;

/**
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="https://hillside.net/plop/plop97/Proceedings/riehle.pdf">Hillside - Role object pattern</a></li>
 * <li><a href="http://wiki.c2.com/?RoleObject">Role object</a></li>
 * <li><a href="https://martinfowler.com/apsupp/roles.pdf">Fowler - Dealing with roles</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/28
 */
public abstract class Customer {

    public abstract boolean addRole(Role role);

    public abstract boolean hasRole(Role role);

    public abstract boolean remRole(Role role);

    public abstract <T extends Customer> Optional<T> getRole(Role role, Class<T> expectedRole);

    public static Customer newCustomer() {
        return new CustomerCore();
    }

    public static Customer newCustomer(Role... role) {
        Customer customer = newCustomer();
        Arrays.stream(role).forEach(customer::addRole);
        return customer;
    }
}
