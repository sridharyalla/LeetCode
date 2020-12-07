package org.sridhar.leetcode;


import java.util.*;

public class MinimumIncompatibility1681 {

    int min = Integer.MAX_VALUE;

    public int minimumIncompatibility(int[] nums, int k) {
        List<TreeSet<Integer>> sets = new ArrayList<>();

        int setSize = nums.length/k;
        for( int i=0; i < k; i++){
            sets.add(new TreeSet<>());
        }

        backtrack(nums, 0, sets, setSize, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void backtrack(int[] nums, int pos, List<TreeSet<Integer>> sets, int setSize, int currentMin){

        if (pos >= nums.length){
            min = Math.min(min, currentMin);
            return;
        }


        Set<TreeSet<Integer>> visited = new HashSet<>();

        for (TreeSet<Integer> set : sets){
            if ( visited.contains(set) || set.contains(nums[pos]) || set.size() == setSize)
                continue;

            int dif =  diff(set, nums[pos]);
            currentMin += dif;

            if( currentMin < min){
                set.add(nums[pos]);
                backtrack(nums, pos+1, sets, setSize , currentMin);
                set.remove(nums[pos]);
            }

            currentMin -= dif;
            visited.add(set);
        }

    }

    private int diff(TreeSet<Integer> set, int num) {
        if (set.size() == 0) return 0;
        if (num < set.first()) return set.first() - num;
        if (num > set.last()) return num - set.last();
        return 0;
    }
}
