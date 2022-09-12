package com.dutianze.designpattern.others.servicelayer.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.dutianze.designpattern.others.servicelayer.aggregate.spell.SpellRepository;
import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBookRepository;
import com.dutianze.designpattern.others.servicelayer.aggregate.wizard.WizardRepository;
import com.dutianze.designpattern.others.servicelayer.service.impl.MagicServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/27
 */
public class ServiceTest {

  @Test
  void testFindAllWizards() {
    final WizardRepository wizardDao = mock(WizardRepository.class);
    final SpellBookRepository spellbookDao = mock(SpellBookRepository.class);
    final SpellRepository spellDao = mock(SpellRepository.class);

    final MagicService service = new MagicServiceImpl(wizardDao, spellbookDao, spellDao);
    verifyNoMoreInteractions(wizardDao, spellbookDao, spellDao);

    service.findAllWizards();
    verify(wizardDao).findAll();
    verifyNoMoreInteractions(wizardDao, spellbookDao, spellDao);
  }
}
