package com.dutianze.designpattern.others.servicelayer.service.impl;

import com.dutianze.designpattern.others.servicelayer.aggregate.spell.Spell;
import com.dutianze.designpattern.others.servicelayer.aggregate.spell.SpellRepository;
import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBook;
import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBookRepository;
import com.dutianze.designpattern.others.servicelayer.aggregate.wizard.Wizard;
import com.dutianze.designpattern.others.servicelayer.aggregate.wizard.WizardRepository;
import com.dutianze.designpattern.others.servicelayer.service.MagicService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Service
@RequiredArgsConstructor
public class MagicServiceImpl implements MagicService {

  private final WizardRepository wizardRepository;
  private final SpellBookRepository spellBookRepository;
  private final SpellRepository spellRepository;

  @Override
  public List<Wizard> findAllWizards() {
    return wizardRepository.findAll();
  }

  @Override
  public List<SpellBook> findAllSpellBooks() {
    return spellBookRepository.findAll();
  }

  @Override
  public List<Spell> findAllSpells() {
    return spellRepository.findAll();
  }

  @Override
  public List<Wizard> findWizardsWithSpellBook(String name) {
    SpellBook spellBook = spellBookRepository.findByName(name);
    return new ArrayList<>(spellBook.getWizards());
  }

  @Override
  public List<Wizard> findWizardsWithSpell(String name) {
    Spell spell = spellRepository.findByName(name);
    SpellBook spellBook = spell.getSpellBook();
    return new ArrayList<>(spellBook.getWizards());
  }
}