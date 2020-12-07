package org.sridhar.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSpiralMatrixII59 {

    SpiralMatrixII59 p = new SpiralMatrixII59();

    @Test
    public void Test1(){
        Assertions.assertArrayEquals(p.generateMatrix(3), new int[][] {{1,2,3},{8,9,4},{7,6,5}});
    }


}
