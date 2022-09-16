package com.dutianze.designpattern.others.domainmodel.product;

import static org.joda.money.CurrencyUnit.USD;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Product {

  private static final int DAYS_UNTIL_EXPIRATION_WHEN_DISCOUNT_ACTIVE = 4;
  private static final double DISCOUNT_RATE = 0.2;

  @NonNull
  private final ProductRepository productDao;
  @NonNull
  private String name;
  @NonNull
  private Money price;
  @NonNull
  private LocalDate expirationDate;

  /**
   * Save product or update if product already exist.
   */
  public void save() {
    try {
      Optional<Product> product = productDao.findByName(name);
      if (product.isPresent()) {
        productDao.update(this);
      } else {
        productDao.save(this);
      }
    } catch (SQLException ex) {
      log.error(ex.getMessage());
    }
  }

  /**
   * Calculate sale price of product with discount.
   */
  public Money getSalePrice() {
    return price.minus(calculateDiscount());
  }

  private Money calculateDiscount() {
    if (ChronoUnit.DAYS.between(LocalDate.now(), expirationDate)
        < DAYS_UNTIL_EXPIRATION_WHEN_DISCOUNT_ACTIVE) {

      return price.multipliedBy(DISCOUNT_RATE, RoundingMode.DOWN);
    }

    return Money.zero(USD);
  }
}
