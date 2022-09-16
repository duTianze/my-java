package com.dutianze.designpattern.others.domainmodel.consumer;

import com.dutianze.designpattern.others.domainmodel.product.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;

/**
 * @author dutianze
 * @date 2022/9/16
 */
@Slf4j
@Getter
@Setter
@Builder
public class Customer {

  @NonNull
  private final CustomerRepository customerDao;
  @Builder.Default
  private List<Product> purchases = new ArrayList<>();
  @NonNull
  private String name;
  @NonNull
  private Money money;

  /**
   * Save customer or update if customer already exist.
   */
  public void save() {
    try {
      Optional<Customer> customer = customerDao.findByName(name);
      if (customer.isPresent()) {
        customerDao.update(this);
      } else {
        customerDao.save(this);
      }
    } catch (SQLException ex) {
      log.error(ex.getMessage());
    }
  }

  /**
   * Add product to purchases, save to db and withdraw money.
   *
   * @param product to buy.
   */
  public void buyProduct(Product product) {
    log.info(
        String.format(
            "%s want to buy %s($%.2f)...",
            name, product.getName(), product.getSalePrice().getAmount()));
    try {
      withdraw(product.getSalePrice());
    } catch (IllegalArgumentException ex) {
      log.error(ex.getMessage());
      return;
    }
    try {
      customerDao.addProduct(product, this);
      purchases.add(product);
      log.info(String.format("%s bought %s!", name, product.getName()));
    } catch (SQLException exception) {
      receiveMoney(product.getSalePrice());
      log.error(exception.getMessage());
    }
  }

  /**
   * Remove product from purchases, delete from db and return money.
   *
   * @param product to return.
   */
  public void returnProduct(Product product) {
    log.info(
        String.format(
            "%s want to return %s($%.2f)...",
            name, product.getName(), product.getSalePrice().getAmount()));
    if (purchases.contains(product)) {
      try {
        customerDao.deleteProduct(product, this);
        purchases.remove(product);
        receiveMoney(product.getSalePrice());
        log.info(String.format("%s returned %s!", name, product.getName()));
      } catch (SQLException ex) {
        log.error(ex.getMessage());
      }
    } else {
      log.error(String.format("%s didn't buy %s...", name, product.getName()));
    }
  }

  /**
   * Print customer's purchases.
   */
  public void showPurchases() {
    Optional<String> purchasesToShow =
        purchases.stream()
            .map(p -> p.getName() + " - $" + p.getSalePrice().getAmount())
            .reduce((p1, p2) -> p1 + ", " + p2);

    if (purchasesToShow.isPresent()) {
      log.info(name + " bought: " + purchasesToShow.get());
    } else {
      log.info(name + " didn't bought anything");
    }
  }

  /**
   * Print customer's money balance.
   */
  public void showBalance() {
    LOGGER.info(name + " balance: " + money);
  }

  private void withdraw(Money amount) throws IllegalArgumentException {
    if (money.compareTo(amount) < 0) {
      throw new IllegalArgumentException("Not enough money!");
    }
    money = money.minus(amount);
  }

  private void receiveMoney(Money amount) {
    money = money.plus(amount);
  }
}
