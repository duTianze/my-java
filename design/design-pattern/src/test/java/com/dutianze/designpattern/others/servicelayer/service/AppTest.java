package com.dutianze.designpattern.others.servicelayer.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.others.servicelayer.aggregate.spell.Spell;
import com.dutianze.designpattern.others.servicelayer.aggregate.spell.SpellRepository;
import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBook;
import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBookRepository;
import com.dutianze.designpattern.others.servicelayer.aggregate.wizard.Wizard;
import com.dutianze.designpattern.others.servicelayer.aggregate.wizard.WizardRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Slf4j
@SpringBootTest
class AppTest {

  public static final String BOOK_OF_IDORES = "Book of Idores";

  @Autowired
  private SpellRepository spellRepository;
  @Autowired
  private SpellBookRepository spellBookRepository;
  @Autowired
  private WizardRepository wizardRepository;
  @Autowired
  private MagicService magicService;

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      log.info("Enumerating all wizards");
      magicService.findAllWizards().stream().map(Wizard::getName).forEach(log::info);

      log.info("Enumerating all spellbooks");
      magicService.findAllSpellBooks().stream().map(SpellBook::getName).forEach(log::info);

      log.info("Enumerating all spells");
      magicService.findAllSpells().stream().map(Spell::getName).forEach(log::info);

      log.info("Find wizards with spellbook 'Book of Idores'");
      List<Wizard> wizardsWithSpellbook = magicService.findWizardsWithSpellBook(BOOK_OF_IDORES);
      wizardsWithSpellbook.forEach(w -> log.info("{} has 'Book of Idores'", w.getName()));

      log.info("Find wizards with spell 'Fireball'");
      List<Wizard> wizardsWithSpell = magicService.findWizardsWithSpell("Fireball");
      wizardsWithSpell.forEach(w -> log.info("{} has 'Fireball'", w.getName()));
    });
  }


  @BeforeEach
  public void loadData() {
    // spells
    Spell spell1 = new Spell("Ice dart");
    Spell spell2 = new Spell("Invisibility");
    Spell spell3 = new Spell("Stun bolt");
    Spell spell4 = new Spell("Confusion");
    Spell spell5 = new Spell("Darkness");
    Spell spell6 = new Spell("Fireball");
    Spell spell7 = new Spell("Enchant weapon");
    Spell spell8 = new Spell("Rock armour");
    Spell spell9 = new Spell("Light");
    Spell spell10 = new Spell("Bee swarm");
    Spell spell11 = new Spell("Haste");
    Spell spell12 = new Spell("Levitation");
    Spell spell13 = new Spell("Magic lock");
    Spell spell14 = new Spell("Summon hell bat");
    Spell spell15 = new Spell("Water walking");
    Spell spell16 = new Spell("Magic storm");
    Spell spell17 = new Spell("Entangle");
    spellRepository.save(spell1);
    spellRepository.save(spell2);
    spellRepository.save(spell3);
    spellRepository.save(spell4);
    spellRepository.save(spell5);
    spellRepository.save(spell6);
    spellRepository.save(spell7);
    spellRepository.save(spell8);
    spellRepository.save(spell9);
    spellRepository.save(spell10);
    spellRepository.save(spell11);
    spellRepository.save(spell12);
    spellRepository.save(spell13);
    spellRepository.save(spell14);
    spellRepository.save(spell15);
    spellRepository.save(spell16);
    spellRepository.save(spell17);

    // spellbooks
    SpellBook spellbook1 = new SpellBook("Book of Orgymon");
    spellBookRepository.save(spellbook1);
    spellbook1.addSpell(spell1);
    spellbook1.addSpell(spell2);
    spellbook1.addSpell(spell3);
    spellbook1.addSpell(spell4);
    spellBookRepository.save(spellbook1);
    SpellBook spellbook2 = new SpellBook("Book of Aras");
    spellBookRepository.save(spellbook2);
    spellbook2.addSpell(spell5);
    spellbook2.addSpell(spell6);
    spellBookRepository.save(spellbook2);
    SpellBook spellbook3 = new SpellBook("Book of Kritior");
    spellBookRepository.save(spellbook3);
    spellbook3.addSpell(spell7);
    spellbook3.addSpell(spell8);
    spellbook3.addSpell(spell9);
    spellBookRepository.save(spellbook3);
    SpellBook spellbook4 = new SpellBook("Book of Tamaex");
    spellBookRepository.save(spellbook4);
    spellbook4.addSpell(spell10);
    spellbook4.addSpell(spell11);
    spellbook4.addSpell(spell12);
    spellBookRepository.save(spellbook4);
    SpellBook spellbook5 = new SpellBook(BOOK_OF_IDORES);
    spellBookRepository.save(spellbook5);
    spellbook5.addSpell(spell13);
    spellBookRepository.save(spellbook5);
    SpellBook spellbook6 = new SpellBook("Book of Opaen");
    spellBookRepository.save(spellbook6);
    spellbook6.addSpell(spell14);
    spellbook6.addSpell(spell15);
    spellBookRepository.save(spellbook6);
    SpellBook spellbook7 = new SpellBook("Book of Kihione");
    spellBookRepository.save(spellbook7);
    spellbook7.addSpell(spell16);
    spellbook7.addSpell(spell17);
    spellBookRepository.save(spellbook7);

    // wizards
    Wizard wizard1 = new Wizard("Aderlard Boud");
    wizardRepository.save(wizard1);
    wizard1.addSpellBook(spellBookRepository.findByName("Book of Orgymon"));
    wizard1.addSpellBook(spellBookRepository.findByName("Book of Aras"));
    wizardRepository.save(wizard1);
    Wizard wizard2 = new Wizard("Anaxis Bajraktari");
    wizardRepository.save(wizard2);
    wizard2.addSpellBook(spellBookRepository.findByName("Book of Kritior"));
    wizard2.addSpellBook(spellBookRepository.findByName("Book of Tamaex"));
    wizardRepository.save(wizard2);
    Wizard wizard3 = new Wizard("Xuban Munoa");
    wizardRepository.save(wizard3);
    wizard3.addSpellBook(spellBookRepository.findByName(BOOK_OF_IDORES));
    wizard3.addSpellBook(spellBookRepository.findByName("Book of Opaen"));
    wizardRepository.save(wizard3);
    Wizard wizard4 = new Wizard("Blasius Dehooge");
    wizardRepository.save(wizard4);
    wizard4.addSpellBook(spellBookRepository.findByName("Book of Kihione"));
    wizardRepository.save(wizard4);
  }


}