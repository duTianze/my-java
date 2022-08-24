package com.dutianze.designpattern.others.specialcase.impl;

import com.dutianze.designpattern.others.specialcase.domain.Db;
import com.dutianze.designpattern.others.specialcase.domain.DomainServices;
import com.dutianze.designpattern.others.specialcase.dto.MoneyTransaction;
import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;
import com.dutianze.designpattern.others.specialcase.dto.impl.InsufficientFunds;
import com.dutianze.designpattern.others.specialcase.dto.impl.InvalidUser;
import com.dutianze.designpattern.others.specialcase.dto.impl.OutOfStock;
import com.dutianze.designpattern.others.specialcase.dto.impl.ReceiptDto;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public class DomainServicesImpl implements DomainServices {

    @Override
    public ReceiptViewModel purchase(String userName, String itemName) {
        Db.User user = Db.getInstance().findUserByUserName(userName);
        if (user == null) {
            return new InvalidUser(userName);
        }

        Db.Account account = Db.getInstance().findAccountByUser(user);
        return purchase(user, account, itemName);
    }

    private ReceiptViewModel purchase(Db.User user, Db.Account account, String itemName) {
        Db.Product item = Db.getInstance().findProductByItemName(itemName);
        if (item == null) {
            return new OutOfStock(user.getUserName(), itemName);
        }

        ReceiptDto receipt = user.purchase(item);
        MoneyTransaction transaction = account.withdraw(receipt.getPrice());
        if (transaction == null) {
            return new InsufficientFunds(user.getUserName(), account.getAmount(), itemName);
        }

        return receipt;
    }
}
