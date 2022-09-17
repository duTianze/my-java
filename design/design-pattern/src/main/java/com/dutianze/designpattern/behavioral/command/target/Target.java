package com.dutianze.designpattern.behavioral.command.target;

import com.dutianze.designpattern.behavioral.command.types.Size;
import com.dutianze.designpattern.behavioral.command.types.Visibility;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Setter
@Slf4j
@Getter
public abstract class Target {

  private Size size;

  private Visibility visibility;

  public void printStatus() {
    log.info("{}, [size={}] [visibility={}]", this, getSize(), getVisibility());
  }

  public void changeSize() {
    Size oldSize = this.size == Size.NORMAL
        ? Size.SMALL : Size.NORMAL;
    setSize(oldSize);
  }

  public void changeVisibility() {
    Visibility visible = this.visibility == Visibility.INVISIBLE
        ? Visibility.VISIBLE : Visibility.INVISIBLE;
    setVisibility(visible);
  }
}