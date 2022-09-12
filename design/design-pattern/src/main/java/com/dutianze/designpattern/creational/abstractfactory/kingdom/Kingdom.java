package com.dutianze.designpattern.creational.abstractfactory.kingdom;

import com.dutianze.designpattern.creational.abstractfactory.fatory.KingdomFactory;
import lombok.Data;

/**
 * @author dutianze
 * @date 2022/8/6
 */
@Data
public class Kingdom {

  private King king;
  private Castle castle;
  private Army army;

  public Kingdom(KingdomFactory kingdomFactory) {
    king = kingdomFactory.createKing();
    castle = kingdomFactory.createCastle();
    army = kingdomFactory.createArmy();
  }
}
