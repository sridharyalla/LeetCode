package org.sridhar.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestPairsOfSongsWithTotalDurationsDivisibleBy60 {

    PairsOfSongsWithTotalDurationsDivisibleBy60 p = new PairsOfSongsWithTotalDurationsDivisibleBy60();

    @Test
    public void test1(){
        Assertions.assertEquals(3, p.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }

    @Test
    public void test2(){
        Assertions.assertEquals(3, p.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
