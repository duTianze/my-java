package com.dutianze.designpattern.others.unitofwork.impl;

import com.dutianze.designpattern.others.unitofwork.IUnitOfWork;
import com.dutianze.designpattern.others.unitofwork.entity.Weapon;
import com.dutianze.designpattern.others.unitofwork.mapper.WeaponMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/19
 */
@Slf4j
@RequiredArgsConstructor
public class WeaponRepositoryImpl implements IUnitOfWork<Weapon> {

    private final Map<String, List<Weapon>> context;
    private final WeaponMapper weaponRepository;

    @Override
    public void registerNew(Weapon weapon) {
        log.info("Registering {} for insert in context.", weapon.getName());
        register(weapon, UnitActions.INSERT.getActionValue());
    }

    @Override
    public void registerModified(Weapon weapon) {
        log.info("Registering {} for modify in context.", weapon.getName());
        register(weapon, UnitActions.MODIFY.getActionValue());

    }

    @Override
    public void registerDeleted(Weapon weapon) {
        log.info("Registering {} for delete in context.", weapon.getName());
        register(weapon, UnitActions.DELETE.getActionValue());
    }

    private void register(Weapon weapon, String operation) {
        List<Weapon> weaponsToOperate = context.get(operation);
        if (weaponsToOperate == null) {
            weaponsToOperate = new ArrayList<>();
        }
        weaponsToOperate.add(weapon);
        context.put(operation, weaponsToOperate);
    }


    @Override
    public void commit() {
        if (context == null || context.size() == 0) {
            return;
        }
        log.info("Commit started");
        if (context.containsKey(UnitActions.INSERT.getActionValue())) {
            commitInsert();
        }
        if (context.containsKey(UnitActions.MODIFY.getActionValue())) {
            commitModify();
        }
        if (context.containsKey(UnitActions.DELETE.getActionValue())) {
            commitDelete();
        }
        log.info("Commit finished.");
    }

    private void commitInsert() {
        List<Weapon> weaponsToBeInserted = context.get(UnitActions.INSERT.getActionValue());
        for (Weapon weapon : weaponsToBeInserted) {
            log.info("Inserting a new weapon {} to sales rack.", weapon.getName());
            weaponRepository.insert(weapon);
        }
    }

    private void commitModify() {
        List<Weapon> modifiedWeapons = context.get(UnitActions.MODIFY.getActionValue());
        for (Weapon weapon : modifiedWeapons) {
            log.info("Scheduling {} for modification work.", weapon.getName());
            weaponRepository.modify(weapon);
        }
    }

    private void commitDelete() {
        List<Weapon> deletedWeapons = context.get(UnitActions.DELETE.getActionValue());
        for (Weapon weapon : deletedWeapons) {
            log.info("Scrapping {}.", weapon.getName());
            weaponRepository.delete(weapon);
        }
    }
}