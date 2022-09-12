package com.dutianze.designpattern.others.unitofwork;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.dutianze.designpattern.others.unitofwork.entity.Weapon;
import com.dutianze.designpattern.others.unitofwork.impl.UnitActions;
import com.dutianze.designpattern.others.unitofwork.impl.WeaponRepositoryImpl;
import com.dutianze.designpattern.others.unitofwork.mapper.WeaponMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/19
 */
class IUnitOfWorkTest {

  private final Weapon weapon1 = new Weapon(1, "battle ram");
  private final Weapon weapon2 = new Weapon(1, "wooden lance");

  private final Map<String, List<Weapon>> context = new HashMap<>();
  private final WeaponMapper weaponMapper = mock(WeaponMapper.class);
  private final IUnitOfWork<Weapon> weaponRepository = new WeaponRepositoryImpl(context,
      weaponMapper);

  @Test
  void useCase() {
    assertDoesNotThrow(() -> {
      // create some weapons
      Weapon enchantedHammer = new Weapon(1, "enchanted hammer");
      Weapon brokenGreatSword = new Weapon(2, "broken great sword");
      Weapon silverTrident = new Weapon(3, "silver trident");

      // perform operations on the weapons
      weaponRepository.registerNew(enchantedHammer);
      weaponRepository.registerModified(silverTrident);
      weaponRepository.registerDeleted(brokenGreatSword);
      weaponRepository.commit();
    });
  }

  @Test
  void shouldSaveNewStudentWithoutWritingToDb() {
    weaponRepository.registerNew(weapon1);
    weaponRepository.registerNew(weapon2);

    assertEquals(2, context.get(UnitActions.INSERT.getActionValue()).size());
    verifyNoMoreInteractions(weaponMapper);
  }

  @Test
  void shouldSaveDeletedStudentWithoutWritingToDb() {
    weaponRepository.registerDeleted(weapon1);
    weaponRepository.registerDeleted(weapon2);

    assertEquals(2, context.get(UnitActions.DELETE.getActionValue()).size());
    verifyNoMoreInteractions(weaponMapper);
  }

  @Test
  void shouldSaveModifiedStudentWithoutWritingToDb() {
    weaponRepository.registerModified(weapon1);
    weaponRepository.registerModified(weapon2);

    assertEquals(2, context.get(UnitActions.MODIFY.getActionValue()).size());
    verifyNoMoreInteractions(weaponMapper);
  }

  @Test
  void shouldSaveAllLocalChangesToDb() {
    context.put(UnitActions.INSERT.getActionValue(), List.of(weapon1));
    context.put(UnitActions.MODIFY.getActionValue(), List.of(weapon1));
    context.put(UnitActions.DELETE.getActionValue(), List.of(weapon1));

    weaponRepository.commit();

    verify(weaponMapper, times(1)).insert(weapon1);
    verify(weaponMapper, times(1)).modify(weapon1);
    verify(weaponMapper, times(1)).delete(weapon1);
  }

  @Test
  void shouldNotWriteToDbIfContextIsNull() {
    IUnitOfWork<Weapon> weaponRepository = new WeaponRepositoryImpl(null, weaponMapper);

    weaponRepository.commit();

    verifyNoMoreInteractions(weaponMapper);
  }

  @Test
  void shouldNotWriteToDbIfNothingToCommit() {
    IUnitOfWork<Weapon> weaponRepository = new WeaponRepositoryImpl(new HashMap<>(), weaponMapper);

    weaponRepository.commit();

    verifyNoMoreInteractions(weaponMapper);
  }

  @Test
  void shouldNotInsertToDbIfNoRegisteredStudentsToBeCommitted() {
    context.put(UnitActions.MODIFY.getActionValue(), List.of(weapon1));
    context.put(UnitActions.DELETE.getActionValue(), List.of(weapon1));

    weaponRepository.commit();

    verify(weaponMapper, never()).insert(weapon1);
  }

  @Test
  void shouldNotModifyToDbIfNotRegisteredStudentsToBeCommitted() {
    context.put(UnitActions.INSERT.getActionValue(), List.of(weapon1));
    context.put(UnitActions.DELETE.getActionValue(), List.of(weapon1));

    weaponRepository.commit();

    verify(weaponMapper, never()).modify(weapon1);
  }

  @Test
  void shouldNotDeleteFromDbIfNotRegisteredStudentsToBeCommitted() {
    context.put(UnitActions.INSERT.getActionValue(), List.of(weapon1));
    context.put(UnitActions.MODIFY.getActionValue(), List.of(weapon1));

    weaponRepository.commit();

    verify(weaponMapper, never()).delete(weapon1);
  }
}