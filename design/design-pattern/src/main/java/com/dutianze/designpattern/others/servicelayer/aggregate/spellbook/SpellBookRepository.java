package com.dutianze.designpattern.others.servicelayer.aggregate.spellbook;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/27
 */
public interface SpellBookRepository extends CrudRepository<SpellBook, Long> {

    SpellBook findByName(String name);

    List<SpellBook> findAll();
}
