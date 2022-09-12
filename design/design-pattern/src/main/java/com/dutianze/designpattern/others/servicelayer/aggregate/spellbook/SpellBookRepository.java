package com.dutianze.designpattern.others.servicelayer.aggregate.spellbook;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author dutianze
 * @date 2022/8/27
 */
public interface SpellBookRepository extends CrudRepository<SpellBook, Long> {

  SpellBook findByName(String name);

  List<SpellBook> findAll();
}
