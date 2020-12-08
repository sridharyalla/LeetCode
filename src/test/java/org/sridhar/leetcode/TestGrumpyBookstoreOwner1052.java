package org.sridhar.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGrumpyBookstoreOwner1052 {

    GrumpyBookstoreOwner1052 p = new GrumpyBookstoreOwner1052();

    @Test
    public void test1(){
        Assertions.assertEquals(16, p.maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1},3));
    }

    @Test
    public void test2(){
        Assertions.assertEquals(3, p.maxSatisfied(new int[] {3}, new int[] {1},1));
    }
}
