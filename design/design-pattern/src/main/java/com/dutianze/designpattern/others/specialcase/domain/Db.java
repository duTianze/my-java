package com.dutianze.designpattern.others.specialcase.domain;

import com.dutianze.designpattern.others.specialcase.dto.MoneyTransaction;
import com.dutianze.designpattern.others.specialcase.dto.impl.ReceiptDto;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public class Db {

  private static Db instance;
  private Map<String, User> userName2User;
  private Map<User, Account> user2Account;
  private Map<String, Product> itemName2Product;

  public static synchronized Db getInstance() {
    if (instance == null) {
      Db newInstance = new Db();
      newInstance.userName2User = new HashMap<>();
      newInstance.user2Account = new HashMap<>();
      newInstance.itemName2Product = new HashMap<>();
      instance = newInstance;
    }
    return instance;
  }

  public void seedUser(String userName, Double amount) {
    User user = new User(userName);
    instance.userName2User.put(userName, user);
    Account account = new Account(amount);
    instance.user2Account.put(user, account);
  }

  public void seedItem(String itemName, Double price) {
    Product item = new Product(price);
    itemName2Product.put(itemName, item);
  }

  public User findUserByUserName(String userName) {
    if (!userName2User.containsKey(userName)) {
      return null;
    }
    return userName2User.get(userName);
  }

  public Account findAccountByUser(User user) {
    if (!user2Account.containsKey(user)) {
      return null;
    }
    return user2Account.get(user);
  }

  public Product findProductByItemName(String itemName) {
    if (!itemName2Product.containsKey(itemName)) {
      return null;
    }
    return itemName2Product.get(itemName);
  }

  public static class User {

    private final String userName;

    public User(String userName) {
      this.userName = userName;
    }

    public String getUserName() {
      return userName;
    }

    public ReceiptDto purchase(Product item) {
      return new ReceiptDto(item.getPrice());
    }
  }

  public static class Account {

    private final Double amount;

    public Account(Double amount) {
      this.amount = amount;
    }

    public MoneyTransaction withdraw(Double price) {
      if (price > amount) {
        return null;
      }
      return new MoneyTransaction(amount, price);
    }

    public Double getAmount() {
      return amount;
    }
  }

  public static class Product {

    private final Double price;

    public Product(Double price) {
      this.price = price;
    }

    public Double getPrice() {
      return price;
    }
  }
}
