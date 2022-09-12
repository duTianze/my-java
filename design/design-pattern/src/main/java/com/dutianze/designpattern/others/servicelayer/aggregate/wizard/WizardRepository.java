package com.dutianze.designpattern.others.servicelayer.aggregate.wizard;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author dutianze
 * @date 2022/8/27
 */
public interface WizardRepository extends CrudRepository<Wizard, Long> {

  List<Wizard> findAll();

  Wizard findByName(String name);
}