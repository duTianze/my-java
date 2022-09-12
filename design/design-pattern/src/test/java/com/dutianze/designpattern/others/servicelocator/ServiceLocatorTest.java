package com.dutianze.designpattern.others.servicelocator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.others.servicelocator.service.Service;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/27
 */
class ServiceLocatorTest {

  public static final String JNDI_SERVICE_A = "jndi/serviceA";
  public static final String JNDI_SERVICE_B = "jndi/serviceB";

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      Service service = ServiceLocator.getService(JNDI_SERVICE_A);
      service.execute();
      service = ServiceLocator.getService(JNDI_SERVICE_B);
      service.execute();
      service = ServiceLocator.getService(JNDI_SERVICE_A);
      service.execute();
      service = ServiceLocator.getService(JNDI_SERVICE_A);
      service.execute();
    });
  }

}