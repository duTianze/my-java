package com.dutianze.designpattern.others.strangler.half;

import com.dutianze.designpattern.others.strangler.neww.NewArithmetic;
import com.dutianze.designpattern.others.strangler.neww.NewSource;
import com.dutianze.designpattern.others.strangler.old.OldArithmetic;
import com.dutianze.designpattern.others.strangler.old.OldSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author dutianze
 * @date 2022/8/24
 */
class HalfSourceTest {

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            final int[] nums = new int[]{1, 2, 3, 4, 5};

            //Before migration
            final OldArithmetic oldSystem = new OldArithmetic(new OldSource());
            oldSystem.sum(nums);
            oldSystem.mul(nums);

            //In process of migration
            final HalfArithmetic halfSystem = new HalfArithmetic(new HalfSource(), new OldSource());
            halfSystem.sum(nums);
            halfSystem.mul(nums);
            halfSystem.ifHasZero(nums);

            //After migration
            final NewArithmetic newSystem = new NewArithmetic(new NewSource());
            newSystem.sum(nums);
            newSystem.mul(nums);
            newSystem.ifHasZero(nums);
        });
    }

}