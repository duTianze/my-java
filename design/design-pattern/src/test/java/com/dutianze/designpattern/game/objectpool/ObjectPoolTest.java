package com.dutianze.designpattern.game.objectpool;

import com.dutianze.designpattern.game.objectpool.oliphaunt.Oliphaunt;
import com.dutianze.designpattern.game.objectpool.oliphaunt.OliphauntPool;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/9/4
 */
@Slf4j
class ObjectPoolTest {

    @Test
    void testSubsequentCheckInCheckout() {
        assertTimeout(ofMillis(5000), () -> {
            final OliphauntPool pool = new OliphauntPool();
            assertEquals("Pool available=0 inUse=0", pool.toString());

            final Oliphaunt expectedOliphaunt = pool.checkOut();
            assertEquals("Pool available=0 inUse=1", pool.toString());

            pool.checkIn(expectedOliphaunt);
            assertEquals("Pool available=1 inUse=0", pool.toString());

            for (int i = 0; i < 100; i++) {
                final Oliphaunt oliphaunt = pool.checkOut();
                assertEquals("Pool available=0 inUse=1", pool.toString());
                assertSame(expectedOliphaunt, oliphaunt);
                assertEquals(expectedOliphaunt.getId(), oliphaunt.getId());
                assertEquals(expectedOliphaunt.toString(), oliphaunt.toString());

                pool.checkIn(oliphaunt);
                assertEquals("Pool available=1 inUse=0", pool.toString());
            }
        });
    }
}