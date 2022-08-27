package com.dutianze.designpattern.others.servicelayer.aggregate.spell;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/27
 */
public interface SpellRepository extends CrudRepository<Spell, Long> {

    Spell findByName(String name);

    List<Spell> findAll();
}

