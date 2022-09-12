package com.dutianze.designpattern.others.roleobject;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.others.roleobject.role.BorrowerRole;
import com.dutianze.designpattern.others.roleobject.role.InvestorRole;
import com.dutianze.designpattern.others.roleobject.role.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class CustomerTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      Customer customer = Customer.newCustomer(Role.Borrower, Role.Investor);
      log.info(" the new customer created : {}", customer);

      boolean hasBorrowerRole = customer.hasRole(Role.Borrower);
      log.info(" customer has a borrowed role - {}", hasBorrowerRole);

      boolean hasInvestorRole = customer.hasRole(Role.Investor);
      log.info(" customer has an investor role - {}", hasInvestorRole);

      customer.getRole(Role.Investor, InvestorRole.class)
          .ifPresent(inv -> {
            inv.setAmountToInvest(1000);
            inv.setName("Billy");
          });
      customer.getRole(Role.Borrower, BorrowerRole.class)
          .ifPresent(inv -> inv.setName("Johny"));

      customer.getRole(Role.Investor, InvestorRole.class)
          .map(InvestorRole::invest)
          .ifPresent(log::info);

      customer.getRole(Role.Borrower, BorrowerRole.class)
          .map(BorrowerRole::borrow)
          .ifPresent(log::info);
    });
  }
}
