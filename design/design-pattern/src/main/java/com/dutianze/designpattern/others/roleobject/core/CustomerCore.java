package com.dutianze.designpattern.others.roleobject.core;

import com.dutianze.designpattern.others.roleobject.Customer;
import com.dutianze.designpattern.others.roleobject.role.Role;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class CustomerCore extends Customer {

  private final Map<Role, CustomerRole> roles;

  public CustomerCore() {
    roles = new HashMap<>();
  }

  @Override
  public boolean addRole(Role role) {
    return role.instance()
        .map(inst -> {
          roles.put(role, inst);
          return true;
        })
        .orElse(false);
  }

  @Override
  public boolean hasRole(Role role) {
    return roles.containsKey(role);
  }

  @Override
  public boolean remRole(Role role) {
    return Objects.nonNull(roles.remove(role));
  }

  @Override
  public <T extends Customer> Optional<T> getRole(Role role, Class<T> expectedRole) {
    return Optional.ofNullable(roles.get(role))
        .filter(expectedRole::isInstance)
        .map(expectedRole::cast);
  }

  @Override
  public String toString() {
    String roles = Arrays.toString(this.roles.keySet().toArray());
    return "Customer{roles=" + roles + "}";
  }
}
