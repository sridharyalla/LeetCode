package org.sridhar.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFindTheMostCompetitiveSubsequence1673 {

    FindTheMostCompetitiveSubsequence1673 p = new FindTheMostCompetitiveSubsequence1673();
    @Test
    public void Test1(){

        Assertions.assertArrayEquals(p.mostCompetitive(new int [] {3,5,2,6}, 2), new int[] {2,6});
    }

    @Test
    public void Test2(){
        Assertions.assertArrayEquals(new int[] {2,3,3,4}, p.mostCompetitive(new int [] {2,4,3,3,5,4,9,6}, 4));
    }

    @Test
    public void TestStack1(){

        Assertions.assertArrayEquals(p.mostCompetitiveStack(new int [] {3,5,2,6}, 2), new int[] {2,6});
    }

    @Test
    public void TestStack2(){
        Assertions.assertArrayEquals(new int[] {2,3,3,4}, p.mostCompetitiveStack(new int [] {2,4,3,3,5,4,9,6}, 4));
    }
}
