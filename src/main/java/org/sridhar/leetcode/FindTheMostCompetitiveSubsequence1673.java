package org.sridhar.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class FindTheMostCompetitiveSubsequence1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();

        int additionalCount = nums.length - k;
        for (int n : nums) {
            while (!q.isEmpty() && q.peekLast()> n  && additionalCount > 0) {
                q.pollLast();
                additionalCount--;
            }
            q.addLast(n);
        }


        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.pollFirst();
        }
        return ans;
    }

    public int[] mostCompetitiveStack(int[] nums, int k) {
        Stack<Integer> q = new Stack<>();

        int additionalCount = nums.length - k;
        for (int n : nums) {
            while (!q.isEmpty() && q.peek()> n  && additionalCount > 0) {
                q.pop();
                additionalCount--;
            }
            q.push(n);
        }

        while (q.size() > k)
            q.pop();

        int[] ans = new int[k];
        for (int i = k-1; i >=0 ; i--) {
            ans[i] = q.pop();
        }
        return ans;
    }
}
