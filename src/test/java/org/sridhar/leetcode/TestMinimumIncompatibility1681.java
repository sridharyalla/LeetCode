package org.sridhar.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMinimumIncompatibility1681 {


    @Test
    public void Test1(){
        MinimumIncompatibility1681 minimumIncompatibility1681 = new MinimumIncompatibility1681();
        Assertions.assertTrue(minimumIncompatibility1681.minimumIncompatibility(new int[]{1, 2, 1, 4}, 2) == 4);
    }
}
