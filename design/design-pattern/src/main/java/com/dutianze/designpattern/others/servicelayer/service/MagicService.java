package com.dutianze.designpattern.others.servicelayer.service;

import com.dutianze.designpattern.others.servicelayer.aggregate.spell.Spell;
import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBook;
import com.dutianze.designpattern.others.servicelayer.aggregate.wizard.Wizard;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/27
 */
public interface MagicService {

  List<Wizard> findAllWizards();

  List<SpellBook> findAllSpellBooks();

  List<Spell> findAllSpells();

  List<Wizard> findWizardsWithSpellBook(String name);

  List<Wizard> findWizardsWithSpell(String name);
}
